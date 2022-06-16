package Lab3Paradigmas.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Player implements Jugador {
    String nombre;
    List<Card> mano;
    List<Card> cartasGanadas;
    int ID;

    public Player(String nombre){
        this.nombre = nombre;
        this.cartasGanadas = new ArrayList<Card>();
        this.mano = new ArrayList<>();
    }

    @Override
    public void recogerCarta(Card carta) {
        this.mano.add(carta);
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public Card verCartasGanadas() {
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Card> getMano() {
        return mano;
    }

    public void setMano(List<Card> mano) {
        this.mano = mano;
    }

    public List<Card> getCartasGanadas() {
        return cartasGanadas;
    }

    public void setCartasGanadas(List<Card> cartasGanadas) {
        this.cartasGanadas = cartasGanadas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

