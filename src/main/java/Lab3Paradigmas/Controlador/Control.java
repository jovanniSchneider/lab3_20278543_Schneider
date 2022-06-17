package Lab3Paradigmas.Controlador;

import Lab3Paradigmas.Modelo.*;

public class Control {
    GameMode modoDeJuego;
    DobbleGame game;
    int cartasARepartir;

    public Control(int numE, int maxCard) {
        this.game = new DobbleGame();
        this.modoDeJuego = null;
        this.game.setCardsSet(new Dobble(numE,maxCard));
    }
    public void registrar(String nombre){
        this.game.registrarJugador(nombre);
    }
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

    public void jugar(){
        this.modoDeJuego.jugar(this.cartasARepartir);
    }
    public Player obtenerGanador(){
        return this.modoDeJuego.obtenerGanador();
    }

    public int getCartasARepartir() {
        return cartasARepartir;
    }

    public void setCartasARepartir(int cartasARepartir) {
        this.cartasARepartir = cartasARepartir;
    }

    public DobbleGame getGame() {
        return game;
    }

    public void setGame(DobbleGame game) {
        this.game = game;
    }

    public GameMode getModoDeJuego() {
        return modoDeJuego;
    }

    public void setModoDeJuego(GameMode modoDeJuego) {
        this.modoDeJuego = modoDeJuego;
    }
}
