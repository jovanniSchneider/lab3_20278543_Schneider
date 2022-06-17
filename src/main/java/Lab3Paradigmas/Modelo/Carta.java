package Lab3Paradigmas.Modelo;

public interface Carta {

    //Dada una carta encontrar la cantidad de cartas necesarias para el conjunto
    int findTotalCards();

    //Dada una carta encontrar la cantidad de elementos necesarios para el conjunto
    int requiredElements();

    //Para obtener el enesimo elemento
    int getNthElement(int n);

    int whichCoincide(Card carta);
}
