package Lab3Paradigmas.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un juego
 */
public class DobbleGame implements Juego {
    List<Player> jugadores;
    int cantidadJugadores = 0;
    Dobble cardsSet;
    int turno = 1; //Es el ID del jugador
    Estado estado;
    List<Card> mazo;

    /**
     * Constructor de la instancia de clase
     */
    public DobbleGame(){
        this.jugadores = new ArrayList<Player>();
        this.mazo = new ArrayList<>();
        estado = Estado.SINCREAR;
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void registrarJugador(String nombre) {
        Player jugador = new Player(nombre);
        jugador.setID(this.cantidadJugadores+1);
        this.jugadores.add(jugador);
        this.cantidadJugadores+=1;
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void crearCardsSet(int cantidadSimbolos, int maxCard) {
        this.cardsSet = new Dobble(cantidadSimbolos,maxCard);
        this.setEstado(Estado.CREADO);
    }

    /**
     * Implementacion de metodo de interface
     */

    @Override
    public void cambiarTurno() {
        if (this.turno == this.cantidadJugadores)
            this.turno = 1;
        else
            this.turno+=1;
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public String verTurno() {
        for(Player p: this.jugadores){
            if(p.ID == this.turno)
                return p.nombre;
        }
        return "No hay un turno establecido";
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public String verEstado() {
        String salida = "Estado sin definir";
        switch (this.estado){
            case SINCREAR:
                salida = "Juego no creado";
                break;
            case CREADO:
                salida = "Juego creado";
                break;
            case INICIADO:
                salida = "Juego iniciado";
                break;
            case ENCURSO:
                salida = "Juego en curso";
                break;
            case FINALIZADO:
                salida = "Juego finalizado";
        }
        return salida;
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void repartirCartas(int cantidad){
        //Para revolver las cartas
        this.cardsSet.shufle();
        for(Card carta: this.getCardsSet().getCartas()){
            this.mazo.add(carta);
        }
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < this.getCantidadJugadores(); j++) {
                this.jugadores.get(j).recogerCarta(this.mazo.get(0));
                this.mazo.remove(0);
            }
        }
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return "DobbleGame{" +
                "jugadores=" + jugadores.toString() +
                ", cantidadJugadores=" + cantidadJugadores +
                ", cardsSet=" + cardsSet.toString() +
                ", estado=" + estado +
                ", mazo=" + mazo.toString() +
                '}';
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
        DobbleGame that = (DobbleGame) o;
        return cantidadJugadores == that.cantidadJugadores && turno == that.turno &&
                Objects.equals(jugadores, that.jugadores) && Objects.equals(cardsSet, that.cardsSet) &&
                estado == that.estado && Objects.equals(mazo, that.mazo);
    }

    /**
     * ------------Getters y Setters----------------
     */
    public List<Player> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
