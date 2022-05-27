package Lab3Paradigmas;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private int cantidadSimbolos;
    private List elementos;

    public Card(List elementos){
        this.elementos = elementos;
        this.cantidadSimbolos = this.elementos.size();
    }

    public int getCantidadSimbolos() {
        return cantidadSimbolos;
    }

    public List getElementos() {
        return elementos;
    }

    public void setCantidadSimbolos(int cantidadSimbolos) {
        this.cantidadSimbolos = cantidadSimbolos;
    }

    public void setElementos(List elementos) {
        this.elementos = elementos;
    }
}
