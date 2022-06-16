package Lab3Paradigmas;

import Lab3Paradigmas.Controlador.Dobble;
import Lab3Paradigmas.Controlador.DobbleGame;
import Lab3Paradigmas.Controlador.StackMode;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DobbleGame juego = new DobbleGame();
        juego.registrarJugador("Jovanni");
        juego.registrarJugador("Pepe");
        juego.crearCardsSet(4,13);
        StackMode game = new StackMode(juego);
        game.jugar();
        System.out.println("Ganador: "+game.obtenerGanador().toString());
    }
}
