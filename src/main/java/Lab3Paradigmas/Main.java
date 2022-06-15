package Lab3Paradigmas;

import Lab3Paradigmas.Controlador.Dobble;
import Lab3Paradigmas.Controlador.DobbleGame;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DobbleGame juego = new DobbleGame();
        juego.registrarJugador("Jovanni");
        juego.registrarJugador("Pepe");
        juego.crearCardsSet(6,31);
        juego.repartirCartas(3);
        System.out.println(juego.toString());
    }
}
