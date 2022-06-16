package Lab3Paradigmas.Controlador;

import java.util.Arrays;

public class Card implements Carta{
    private int cantidadSimbolos;
    private int [] elementos;

    public Card(int [] elementos){
        int [] aux = elementos.clone();
        this.elementos = aux;
        this.cantidadSimbolos = this.elementos.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementos);
    }
    public int findTotalCards(){
        int n = this.cantidadSimbolos - 1;
        return n^2+n+1;
    }
    public int requiredElements(){
        return this.findTotalCards();
    }

    @Override
    public int getNthElement(int n) {
        return this.elementos[n];
    }

    public int whichCoincide(Card carta) {
        for (int i = 0; i < cantidadSimbolos; i++) {
            for (int j = 0; j < cantidadSimbolos; j++) {
                if (this.elementos[i] == carta.elementos[j])
                    return this.elementos[i];
            }
        }
        return -1;
    }

    public int getCantidadSimbolos() {
        return cantidadSimbolos;
    }

    public int[] getElementos() {
        return elementos;
    }

    public void setCantidadSimbolos(int cantidadSimbolos) {
        this.cantidadSimbolos = cantidadSimbolos;
    }

    public void setElementos(int [] elementos) {
        this.elementos = elementos;
    }
}
