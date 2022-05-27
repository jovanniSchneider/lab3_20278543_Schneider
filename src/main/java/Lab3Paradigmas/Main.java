package Lab3Paradigmas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List simbolos = new ArrayList();
        simbolos.add(3);
        simbolos.add("jaje");
        Card carta = new Card(simbolos);
        Card [] cartas = new Card[3];
        cartas[0] = carta;
        cartas[1] = carta;
        cartas[2] = carta;

    }
}
