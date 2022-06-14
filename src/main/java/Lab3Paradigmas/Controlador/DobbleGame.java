package Lab3Paradigmas.Controlador;

import java.util.ArrayList;
import java.util.List;

public class DobbleGame implements Juego {
    List<Player> jugadores;
    int cantidadJugadores = 0;
    Dobble cardsSet;
    int turno = 1; //Es el ID del jugador
    Estado estado;

    public DobbleGame(){
        this.jugadores = new ArrayList<Player>();
        estado = Estado.SINCREAR;
    }

    @Override
    public void registrarJugador(String nombre) {
        Player jugador = new Player(nombre);
        this.jugadores.add(jugador);
        this.cantidadJugadores+=1;
    }

    @Override
    public void cambiarTurno() {
        if (this.turno == this.cantidadJugadores -1)
            this.turno = 1;
        else
            this.turno+=1;
    }

    @Override
    public void verTurno() {

    }

    @Override
    public void verEstado() {

    }

    @Override
    public void repartirCartas() {

    }
}
