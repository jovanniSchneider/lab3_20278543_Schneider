package Lab3Paradigmas.Controlador;

public interface Juego {
    void registrarJugador(String nombre);
    void cambiarTurno();
    void verTurno();
    void verEstado();
    void repartirCartas();
}
