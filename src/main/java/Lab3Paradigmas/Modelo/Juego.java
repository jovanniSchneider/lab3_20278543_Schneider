package Lab3Paradigmas.Modelo;

public interface Juego {
    /**
     * Permite registrar un jugador en el juego
     * @param nombre del jugador a registrar
     */
    void registrarJugador(String nombre);

    /**
     * Permite crear una instancia de la clase Dobble
     * @param cantidadSimbolos para pasarle al constructor de Dobble
     * @param maxCard para pasarle al constructor de Dobble
     */
    void crearCardsSet(int cantidadSimbolos, int maxCard);

    /**
     * Permite cambiar el turno correspondiente del juego
     */
    void cambiarTurno();

    /**
     * Entrega como String a quien le corresponde el turno
     * @return el nombre de quien tiene el turno
     */
    String verTurno();

    /**
     * Verifica cual es el estado del juego
     * @return una representacion en string del estado del juego
     */
    String verEstado();

    /**
     * Entrega cierta cantidad de cartas a cada jugador
     * @param cantidad de cartas a repartir
     */
    void repartirCartas(int cantidad);
}
