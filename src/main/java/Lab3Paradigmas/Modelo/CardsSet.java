package Lab3Paradigmas.Modelo;

public interface CardsSet {
    /**
     *Para agregar una carta al cardsSet
     * @param simbolos los simbolos que contiene la carta
     * @param donde un indice que indica en que atributo de la instancia se agregará la carta
     */
    void addCarta(int[] simbolos, int donde);

    /**
     * Para mostrar las cartas por consola
     */
    void mostrarCartas();

    /**
     * Devuelve la enesima carta
     * @param n el indice de la carta que se desea obtener
     * @return una instancia de la clase Card
     */
    Card getNthCard(int n);


    /**
     * Mezcla las cartas del conjunto antes de repartir
     */
    void shufle();

    /**
     * Para verificar que el cardset es correcto
     */
    boolean esCorrecto();
}
