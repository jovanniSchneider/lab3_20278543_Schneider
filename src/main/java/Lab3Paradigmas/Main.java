package Lab3Paradigmas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> simbolos;
        simbolos = new ArrayList<Integer>();
        simbolos.add(3);
        simbolos.add(4);
        simbolos.add(5);
        Card carta = new Card(simbolos);
        Card [] cartas = new Card[3];
        cartas[0] = carta;
        cartas[1] = carta;
        cartas[2] = carta;
        Dobble cartas2 = new Dobble(cartas,3);
        cartas2.mostrarCartas();
    }
}
