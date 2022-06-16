package Lab3Paradigmas.Controlador;

import java.util.Scanner;
import java.util.function.Function;

public class StackMode implements GameMode {
    DobbleGame game;
    Player ganador;
    Card carta1;
    Card carta2;
    public StackMode(DobbleGame game) {
        this.game = game;
    }
    public void jugar(){
        Scanner scanner = new Scanner(System.in);
        this.game.setEstado(Estado.INICIADO);
        this.game.repartirCartas(0);
        int eleccion;
        while(this.game.mazo.size()>1){
            this.game.setEstado(Estado.ENCURSO);
            carta1 = this.game.mazo.get(0);
            carta2 = this.game.mazo.get(1);
            this.game.mazo.remove(0);
            this.game.mazo.remove(0);
            System.out.println("Turno de " + this.game.verTurno());
            System.out.println("carta 1 = " + carta1);
            System.out.println("carta 2 = " + carta2);
            System.out.println("Que elemento coincide?: ");
            eleccion = scanner.nextInt();
            if (eleccion == carta1.whichCoincide(carta2)){
                this.game.jugadores.stream().map(player -> {
                    if(player.nombre == this.game.verTurno()){
                        player.cartasGanadas.add(carta1);
                        player.cartasGanadas.add(carta2);
                    }
                    return null;
                });
                System.out.println("Correcto!!!");
            }else
                System.out.println("Incorrecto!!!");
            game.cambiarTurno();
        }
        this.game.setEstado(Estado.FINALIZADO);
    }
    public Player obtenerGanador(){
        this.ganador = this.game.jugadores.get(0);
        for (int i = 1; i < this.game.getCantidadJugadores(); i++) {
            if(this.game.jugadores.get(i).cartasGanadas.size()>ganador.cartasGanadas.size()){
                ganador = this.game.jugadores.get(i);
            }
        }
        return this.ganador;
    }
}
