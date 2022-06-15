package Lab3Paradigmas.Controlador;

import java.util.ArrayList;
import java.util.List;

public class DobbleGame implements Juego {
    List<Player> jugadores;
    int cantidadJugadores = 0;
    Dobble cardsSet;
    int turno = 1; //Es el ID del jugador
    Estado estado;
    List<Card> mazo;
    GameMode gameMode;

    public DobbleGame(){
        this.jugadores = new ArrayList<Player>();
        this.mazo = new ArrayList<>();
        estado = Estado.SINCREAR;
    }


    @Override
    public void registrarJugador(String nombre) {
        Player jugador = new Player(nombre);
        this.jugadores.add(jugador);
        this.cantidadJugadores+=1;
    }

    @Override
    public void crearCardsSet(int cantidadSimbolos, int maxCard) {
        this.cardsSet = new Dobble(cantidadSimbolos,maxCard);
    }

    @Override
    public void cambiarTurno() {
        if (this.turno == this.cantidadJugadores -1)
            this.turno = 1;
        else
            this.turno+=1;
    }

    @Override
    public String verTurno() {
        for(Player p: this.jugadores){
            if(p.ID == this.turno)
                return p.nombre;
        }
        return "No hay un turno establecido";
    }

    @Override
    public String verEstado() {
        String salida = "Estado sin definir";
        switch (this.estado){
            case SINCREAR:
                salida = "Juego no creado";
                break;
            case CREADO:
                salida = "Juego creado";
                break;
            case INICIADO:
                salida = "Juego iniciado";
                break;
            case ENCURSO:
                salida = "Juego en curso";
                break;
            case FINALIZADO:
                salida = "Juego finalizado";
        }
        return salida;
    }
    @Override
    public void repartirCartas(int cantidad){
        //Para revolver las cartas
        this.cardsSet.shufle();
        for(Card carta: this.getCardsSet().getCartas()){
            this.mazo.add(carta);
        }
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < this.getCantidadJugadores(); j++) {
                this.jugadores.get(j).recogerCarta(this.mazo.get(0));
                this.mazo.remove(0);
            }
        }
    }

    @Override
    public String toString() {
        return "DobbleGame{" +
                "jugadores=" + jugadores.toString() +
                ", cantidadJugadores=" + cantidadJugadores +
                ", cardsSet=" + cardsSet.toString() +
                ", estado=" + estado +
                ", mazo=" + mazo.toString() +
                '}';
    }

    public List<Player> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Player> jugadores) {
        this.jugadores = jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Card> getMazo() {
        return mazo;
    }

    public void setMazo(List<Card> mazo) {
        this.mazo = mazo;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
