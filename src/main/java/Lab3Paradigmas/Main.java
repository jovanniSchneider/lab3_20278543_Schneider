package Lab3Paradigmas;

import Lab3Paradigmas.Controlador.Dobble;

public class Main {
    public static void main(String[] args) {
        Dobble cartas2 = new Dobble(3,7);
        cartas2.shufle();
        cartas2.mostrarCartas();
        System.out.println(cartas2.getNthCard(4).findTotalCards());
    }
}
