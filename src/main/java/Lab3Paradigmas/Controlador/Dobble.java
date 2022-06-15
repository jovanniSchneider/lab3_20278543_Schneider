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

    @Override
    public boolean esCorrecto() {
        int n = this.cartas.get(0).getCantidadSimbolos()-1;
        List<Integer> primos = nPrimos(n);
        boolean flag = false;
        for(Integer i: primos){
            if(this.powOf(n,i))
                flag = true;
        }
        if (!(this.isPrime(n)))
            return false;

        for (int i = 0; i < this.cantidadCartas; i++) {
            for (int j = i+1; j < this.cantidadCartas; j++) {
                if (this.cartas.get(i).whichCoincide(this.cartas.get(j)) == -1)
                    return false;
            }
        }
        if (flag)
            return true;
        return false;
    }

    private boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    private List<Integer> nPrimos(int n){
        List <Integer> primos = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if (this.isPrime(i))
                primos.add(i);
        }
        return primos;
    }

    private boolean powOf(int a, int b){
        while (a!=1){
            if (a%b == 0)
                a/=b;
            else
                return false;
        }
        return true;
    }

    public int getCantidadCartas() {
        return this.cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }



}
