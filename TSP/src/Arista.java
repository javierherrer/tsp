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

//    public boolean contiene(Vertice vertice) {
//        return origen.equals(vertice) || destino.equals(vertice);
//    }

    public int obtenerCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "(" + origen + ", " + destino + ", " + coste+ ")";
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

    public int devolverOrigen(){
        return origen.obtenerId();
    }
    public int devolverDestino(){
        return destino.obtenerId();
    }
}
