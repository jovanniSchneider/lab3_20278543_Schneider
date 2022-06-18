package Lab3Paradigmas.Controlador;

import Lab3Paradigmas.Modelo.*;

/**
 * Clase Control se encarga de controlar el flujo del juego interactuando con el menu, es el encargado
 * de acciones como crear el juego, registrar jugador,etc.
 * @author Jovanni Schneider
 */
public class Control {
    GameMode modoDeJuego;
    DobbleGame game;
    int cartasARepartir;

    /**
     * Costructor de Control, recibe los parametros que le entregará al contructor de un Dobble
     * @param numE cantidad de simbolos por carta
     * @param maxCard cantidad de cartas que desea el usuario
     */
    public Control(int numE, int maxCard) {
        this.game = new DobbleGame();
        this.modoDeJuego = null;
        this.game.setCardsSet(new Dobble(numE,maxCard));
    }

    /**
     * Se encarga de llamar al metodo registrarJugador de la instancia de DobbleGame
     * @param nombre es el nombre del jugador a registrar
     */
    public void registrar(String nombre){
        this.game.registrarJugador(nombre);
    }

    /**
     * Metodo para setear el modo de juego en base a un indice que puede ser 1 o 2
     * @param mode es el indice del juego
     */
    public void elegirModo(int mode){
        switch(mode){
            case 1:
                this.modoDeJuego = new StackMode(game);
                this.cartasARepartir = 0;
                break;
            case 2:
                this.modoDeJuego = new EHS(game);
                break;
        }
    }

    /**
     * Se encarga de utilizar el metodo jugar de la instancia del modo de juego
     */
    public void jugar(){
        this.modoDeJuego.jugar(this.cartasARepartir);
    }

    /**
     * Utiliza el motodo obtenerGanador de un GameMode
     * @return el jugador ganador de la partida
     */
    public Player obtenerGanador(){
        return this.modoDeJuego.obtenerGanador();
    }

    /**
     * getter para la cantidad de cartas que se reparten a cada jugador
     * @return la cantidad de cartas a repartir
     */
    public int getCartasARepartir() {
        return cartasARepartir;
    }

    /**
     * setter para la cantidad de cartas que se reparten a cada jugador
     * @param cartasARepartir es la cantidad de cartas a repartir
     */
    public void setCartasARepartir(int cartasARepartir) {
        this.cartasARepartir = cartasARepartir;
    }

    /**
     * getter para el juego de la instancia de Control
     * @return una instancia de DobbleGame
     */
    public DobbleGame getGame() {
        return game;
    }

    /**
     * getter para el modo de juego
     * @return una instancia de una clase que implementa GameMode
     */
    public GameMode getModoDeJuego() {
        return modoDeJuego;
    }
}
