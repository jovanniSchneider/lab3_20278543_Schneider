package Lab3Paradigmas.Modelo;

import java.util.Objects;
import java.util.Scanner;

/**
 * Clase que representa el modo de juego Stack
 * @author Jovanni Schneider
 */
public class StackMode implements GameMode {
    DobbleGame game;
    Player ganador;
    Card carta1;
    Card carta2;

    /**
     * Constructor de Stack
     * @param game es un juego valido con el que se va a jugar
     */
    public StackMode(DobbleGame game) {
        this.game = game;
    }
    /**
     * Implementacion del metodo de interface
     * Realiza toda la partida del modo de juego
     */
    public void jugar(int cartasARepartir){
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
    /**
     * Implementacion del metodo de interface
     */
    public Player obtenerGanador(){
        this.ganador = this.game.jugadores.get(0);
        for (int i = 1; i < this.game.getCantidadJugadores(); i++) {
            if(this.game.jugadores.get(i).cartasGanadas.size()>ganador.cartasGanadas.size()){
                ganador = this.game.jugadores.get(i);
            }
        }
        return this.ganador;
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return "Stack";
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
        StackMode stackMode = (StackMode) o;
        return Objects.equals(game, stackMode.game) && Objects.equals(ganador, stackMode.ganador) &&
                Objects.equals(carta1, stackMode.carta1) && Objects.equals(carta2, stackMode.carta2);
    }
}
