package Lab3Paradigmas;

import java.util.List;

public class Dobble {
    private Card[] cartas;
    private int cantidadCartas;

    public Dobble(Card[] cartas, int cantidadCartas) {
        this.cartas = cartas;
        this.cantidadCartas = cantidadCartas;
    }

    public Card[] getCartas() {
        return cartas;
    }

    public void setCartas(Card[] cartas) {
        this.cartas = cartas;
    }

    public int getCantidadCartas() {
        return cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }

    public void mostrarCartas(){
        for (int i = 0; i < this.getCantidadCartas(); i++) {
            System.out.println("Carta "+ i +" = " + this.getCartas()[i].getElementos());
        }
    }


}
