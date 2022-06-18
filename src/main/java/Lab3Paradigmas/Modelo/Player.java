package Lab3Paradigmas.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un jugador
 */
public class Player implements Jugador {
    String nombre;
    List<Card> mano;
    List<Card> cartasGanadas;
    int ID;

    /**
     * Constructor del jugador
     * @param nombre del jugador
     */
    public Player(String nombre){
        this.nombre = nombre;
        this.cartasGanadas = new ArrayList<Card>();
        this.mano = new ArrayList<>();
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void recogerCarta(Card carta) {
        this.mano.add(carta);
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     *---------Getters and Setters---------
     */
    public List<Card> getMano() {
        return mano;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

