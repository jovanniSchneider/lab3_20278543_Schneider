package Lab3Paradigmas.Modelo;

public interface Carta {

    /**
     * Dada una carta encontrar la cantidad de cartas necesarias para el conjunto
     * @return la cantidad de cartas que se deben construir
     */
    int findTotalCards();

    /**
     * Dada una carta encontrar la cantidad de elementos necesarios para el conjunto
     * @return la cantidad de elementos que se necesitan
     */
    int requiredElements();

    /**
     * Para obtener el enesimo elemento
     * @param n indice del elemento a obtener
     * @return el elemento de indice n
     */
    int getNthElement(int n);

    int whichCoincide(Card carta);
}
