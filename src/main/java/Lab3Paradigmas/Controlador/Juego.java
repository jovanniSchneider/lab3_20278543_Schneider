package Lab3Paradigmas.Controlador;

public interface Juego {
    void registrarJugador(String nombre);
    void crearCardsSet(int cantidadSimbolos, int maxCard);
    void cambiarTurno();
    String verTurno();
    String verEstado();
    void repartirCartas(int cantidad);
}
