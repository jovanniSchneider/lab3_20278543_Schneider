package Lab3Paradigmas.Modelo;

public interface Juego {
    void registrarJugador(String nombre);
    void crearCardsSet(int cantidadSimbolos, int maxCard);
    void cambiarTurno();
    String verTurno();
    String verEstado();
    void repartirCartas(int cantidad);
}
