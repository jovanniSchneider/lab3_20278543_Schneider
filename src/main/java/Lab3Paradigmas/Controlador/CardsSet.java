package Lab3Paradigmas.Controlador;

public interface CardsSet {
    //Para agregar una carta al conjunto

    void addCarta(int[] simbolos, int donde);

    //Para mostrar las cartas por consola
    void mostrarCartas();

    //Para obtener la enesima carta
    Card getNthCard(int n);

    //Para mezclar el conjunto
    void shufle();

    //Para verificar que el cardset es correcto
    boolean esCorrecto();
}
