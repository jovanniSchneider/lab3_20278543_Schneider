package Lab3Paradigmas.Modelo;

import java.util.Arrays;

/**
 * Clase que representa a una carta
 */
public class Card implements Carta{
    private int cantidadSimbolos;
    private int [] elementos;

    /**
     * Constructor de una carta
     * @param elementos son los elementos que tendrá la carta
     */
    public Card(int [] elementos){
        int [] aux = elementos.clone();
        this.elementos = aux;
        this.cantidadSimbolos = this.elementos.length;
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return Arrays.toString(elementos)+"\n";
    }


    /**
     * Verifica si una instancia es igual a otro objeto
     * @param o objeto con el que se desea comparar
     * @return true o false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cantidadSimbolos == card.cantidadSimbolos && Arrays.equals(elementos, card.elementos);
    }

    /**
     * Implementacion del metodo de interface
     */
    @Override
    public int findTotalCards(){
        int n = this.cantidadSimbolos - 1;
        return n^2+n+1;
    }

    /**
     * Implementacion del metodo de interface
     */
    @Override
    public int requiredElements(){
        return this.findTotalCards();
    }


    /**
     * Implementacion del metodo de interface
     */
    @Override
    public int getNthElement(int n) {
        return this.elementos[n];
    }

    /**
     * Implementacion del metodo de interface
     */
    public int whichCoincide(Card carta) {
        for (int i = 0; i < cantidadSimbolos; i++) {
            for (int j = 0; j < cantidadSimbolos; j++) {
                if (this.elementos[i] == carta.elementos[j])
                    return this.elementos[i];
            }
        }
        return -1;
    }

    /**
     * Getter para la cantidad de simbolos
     * @return un entero que representa la cantidad de simbolos
     */
    public int getCantidadSimbolos() {
        return cantidadSimbolos;
    }
}
