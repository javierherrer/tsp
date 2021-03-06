import java.util.Arrays;

public class Arista {
    public Vertice origen;
    public Vertice destino;


    public Arista(int origen, int destino){
        this.origen = new Vertice(origen);
        this.destino = new Vertice(destino);
    }

    @Override
    public String toString() {
        //TODO
        return "Arista{" +
                "Origen=" + origen +
                " Destino="+destino +
                '}';
    }
}
