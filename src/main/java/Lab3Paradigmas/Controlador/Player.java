package Lab3Paradigmas.Controlador;

import java.util.ArrayList;
import java.util.List;

public class Player implements Jugador {
    String nombre;
    List<Card> cartasGanadas;
    int ID;


    public Player(String nombre){
        this.nombre = nombre;
        this.cartasGanadas = new ArrayList<Card>();
    }

    @Override
    public void jugar() {

    }

    @Override
    public void verJugadas() {

    }

    @Override
    public Card verCartasGanadas() {
        return null;
    }
}
