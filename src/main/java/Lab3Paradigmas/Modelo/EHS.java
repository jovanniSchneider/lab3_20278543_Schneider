package Lab3Paradigmas.Modelo;

import java.util.Objects;
import java.util.Scanner;

/**
 * Clase que represeta el modo de juego Empty Hand Stack
 */
public class EHS implements GameMode{
    DobbleGame game;
    Player ganador;

    /**
     * Constructor de EHS
     * @param game es un juego valido con el que se va a jugar
     */
    public EHS(DobbleGame game) {
        this.game = game;
    }

    /**
     * Verifica si un jugador se quedo sin cartas en la mano
     * @param jugador es el jugador a verificar
     * @return true o false
     */
    private boolean sinCartas(Player jugador){
            return jugador.getMano().size() == 0;
    }

    /**
     * Implementacion del metodo de interface
     * Realiza toda la partida del modo de juego
     */
    @Override
    public void jugar(int cartasARepartir) {
        Scanner scanner = new Scanner(System.in);
        Player jugadorDeTurno = this.game.jugadores.get(0);
        int eleccion;
        this.game.setEstado(Estado.INICIADO);
        this.game.repartirCartas(cartasARepartir);
        while(this.game.jugadores.stream().filter(jugador -> this.sinCartas(jugador)).toArray().length == 0){
            System.out.println("Turno de " + this.game.verTurno());
            Card cartaDelMazo = this.game.mazo.get(0);
            for(Player p: this.game.jugadores){
                if (p.nombre == this.game.verTurno()) {
                    System.out.println("Cartas restantes en el mazo = "+this.game.mazo.size());
                    System.out.println("Cartas restantes de "+p.nombre+" = "+p.mano.size());
                    System.out.println("carta del mazo = " + cartaDelMazo.toString());
                    System.out.println("carta de " + p.nombre + " = " +p.mano.get(0).toString());
                    System.out.println("Que elemento coincide?: ");
                    eleccion = scanner.nextInt();
                    if (eleccion == p.getMano().get(0).whichCoincide(cartaDelMazo)){
                        this.game.mazo.add(this.game.mazo.size(), p.getMano().get(0));
                        p.mano.remove(0);
                        System.out.println("Correcto!!!");
                        this.game.mazo.remove(0);
                        this.game.mazo.add(this.game.mazo.size(),cartaDelMazo);
                        break;
                    }else
                        System.out.println("Incorrecto!!!");
                }
            }
            this.game.cambiarTurno();
        }
        scanner.close();
    }

    /**
     * Implementacion del metodo de interface
     */
    @Override
    public Player obtenerGanador() {
        for (int i = 0; i < this.game.jugadores.size(); i++) {
            if (this.game.jugadores.get(i).getMano().size() == 0)
                this.ganador = this.game.jugadores.get(i);
        }
        return this.ganador;
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return "Empty Hand Stack";
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
        EHS ehs = (EHS) o;
        return Objects.equals(game, ehs.game) && Objects.equals(ganador, ehs.ganador);
    }
}
