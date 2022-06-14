package Lab3Paradigmas.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dobble implements CardsSet {
    private List<Card> cartas;
    private int cantidadCartas;
    private List<Card> missingCards;

    public Dobble(int cantidadSimbolos, int maxCards) {
        int n = cantidadSimbolos-1;
        cartas = new ArrayList<Card>();
        missingCards = new ArrayList<Card>();
        int preCarta[] = new int[cantidadSimbolos];
        for (int i = 1; i <= cantidadSimbolos; i++) {
            preCarta[i-1] = i;
        }
        if(this.cartas.size()>= maxCards)
            this.addCarta(preCarta,2);
        else
            this.addCarta(preCarta,1);
        for (int i = 1; i <= n; i++) {
            preCarta[0] = (1);
            for (int j = 1; j <= n; j++) {
                preCarta[j] = n*i+(j+1);
            }
            if(this.cartas.size()>= maxCards)
                this.addCarta(preCarta,2);
            else
                this.addCarta(preCarta,1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preCarta[0] = i+1;
                for (int k = 1; k <= n; k++) {
                    preCarta[k] = n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n);
                }
                if(this.cartas.size()>= maxCards)
                    this.addCarta(preCarta,2);
                else
                    this.addCarta(preCarta,1);
            }
        }
        this.cantidadCartas = this.cartas.size();
    }

    public void addCarta(int[] simbolos, int donde) {
        Card carta = new Card(simbolos);
        switch (donde){
            case 1:
                this.cartas.add(carta);
                break;
            case 2:
                this.missingCards.add(carta);
                break;
        }
    }

    public String toString() {
        return "Dobble{" +
                "cantidadCartas=" + cantidadCartas +
                "\ncartas=\n" + cartas.toString() +
                "\nmissingCards=\n" + missingCards.toString() +
                '}';
    }

    public void mostrarCartas(){
        System.out.println(this.toString());
    }

    public List<Card> getCartas() {
        return this.cartas;
    }

    public Card getNthCard(int n){
        if (n < this.cantidadCartas){
            return this.getCartas().get(n);
        }else
            return null;
    }
    public void shufle(){
        Random random = new Random();
        int indice;
        Card aux;
        for (int i = 0; i < this.cantidadCartas; i++) {
            indice = random.nextInt(i+1);
            if (indice!=i){
                aux = this.getNthCard(indice);
                this.cartas.set(indice,this.getNthCard(i));
                this.cartas.set(i,aux);
            }
        }
    }
    public int getCantidadCartas() {
        return this.cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }


}
