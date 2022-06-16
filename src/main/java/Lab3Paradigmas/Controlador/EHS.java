package Lab3Paradigmas.Controlador;

import java.util.Scanner;

public class EHS implements GameMode{
    DobbleGame game;
    Player ganador;

    public EHS(DobbleGame game) {
        this.game = game;
    }

    @Override
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        this.game.setEstado(Estado.INICIADO);
        this.game.repartirCartas(0);

    }

    @Override
    public Player obtenerGanador() {
        return null;
    }
}
