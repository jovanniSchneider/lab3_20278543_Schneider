package Lab3Paradigmas.Modelo;

public interface GameMode {
    /**
     * Permite jugar una partida completa dentro del modo de juego
     * @param cartasARepartir la cantidad de cartas que repartiran a cada jugador en el modo de juego
     */
    void jugar(int cartasARepartir);

    /**
     * Permite obtener al ganador del modo de juego
     * @return el jugador ganador
     */
    Player obtenerGanador();
}
