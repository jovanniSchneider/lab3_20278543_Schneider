package Lab3Paradigmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dobble {
    private List<Card> cartas;
    private int cantidadCartas;

    public Dobble(int cantidadSimbolos) {
        int n = cantidadSimbolos-1;
        cartas = new ArrayList<Card>();
        int preCarta[] = new int[cantidadSimbolos];
        for (int i = 1; i <= cantidadSimbolos; i++) {
            preCarta[i-1] = i;
        }
        this.addCarta(preCarta);
        for (int i = 1; i <= n; i++) {
            preCarta[0] = (1);
            for (int j = 1; j <= n; j++) {
                preCarta[j] = n*i+(j+1);
            }
            this.addCarta(preCarta);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preCarta[0] = i+1;
                for (int k = 1; k <= n; k++) {
                    preCarta[k] = n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n);
                }
                this.addCarta(preCarta);
            }
        }
        this.cantidadCartas = this.cartas.size();
    }

    public List<Card> getCartas() {
        return this.cartas;
    }

    public void addCarta(int [] simbolos) {
        Card carta = new Card(simbolos);
        this.cartas.add(carta);
    }

    public int getCantidadCartas() {
        return this.cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }

    public void mostrarCartas(){
        for (int i = 0; i < this.getCantidadCartas(); i++) {
            System.out.println("Carta " + (i+1) + " = " + Arrays.toString(this.getCartas().get(i).getElementos()));
        }
    }


}
