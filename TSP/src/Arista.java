import java.util.Arrays;

public class Arista implements Comparable<Arista>{
    private Vertice origen;
    private Vertice destino;
    private int coste;


    public Arista(int origen, int destino, int coste){
        this.origen = new Vertice(origen);
        this.destino = new Vertice(destino);
        this.coste = coste;
    }

    public Arista(Vertice origen, Vertice destino){
        this.origen = origen;
        this.destino = destino;
    }

//    public boolean contiene(Vertice vertice) {
//        return origen.equals(vertice) || destino.equals(vertice);
//    }

    public int obtenerCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "(" + origen + ", " + destino + ")";
    }

    @Override
    public int compareTo(Arista arista) {
        if (coste < arista.coste){
            return -1;
        }
        if (coste == arista.coste){
            return 0;
        }
        return 1;
    }

    public Vertice obtenerOrigen(){
        return origen;
    }

    public Vertice obtenerDestino(){
        return destino;
    }
}
