package Lab3Paradigmas;

public class Card {
    private int cantidadSimbolos;
    private int [] elementos;

    public Card(int [] elementos){
        int [] aux = elementos.clone();
        this.elementos = aux;
        this.cantidadSimbolos = this.elementos.length;
    }

    public int getCantidadSimbolos() {
        return cantidadSimbolos;
    }

    public int[] getElementos() {
        return elementos;
    }

    public void setCantidadSimbolos(int cantidadSimbolos) {
        this.cantidadSimbolos = cantidadSimbolos;
    }

    public void setElementos(int [] elementos) {
        this.elementos = elementos;
    }
}
