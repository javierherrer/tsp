import java.util.Arrays;

public class Arista {
    private Vertice origen;
    private Vertice destino;
    private int coste;


    public Arista(int origen, int destino, int coste){
        this.origen = new Vertice(origen);
        this.destino = new Vertice(destino);
        this.coste = coste;
    }

    public int obtenerCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "(" + origen + ", " + destino + ")";
    }
}
