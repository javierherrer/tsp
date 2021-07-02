import java.util.*;

public class Nodo implements Comparable{

    private Vertice vertice;

    private Nodo padre;
    private List<Vertice> visitados;
    private Matriz matriz;
    public int costeEstimado;

    public Nodo(Vertice vertice, Matriz matriz, int L){
        this.vertice = vertice;
        this.costeEstimado = L;
        visitados = new ArrayList<>();
        this.matriz = matriz;
        visitados.add(vertice);
    }


    public Nodo(Vertice vertice, Nodo padre){
        this.vertice = vertice;
        this.visitados = new ArrayList<>(padre.visitados);
        this.padre = padre;
        this.matriz = new Matriz(padre.matriz);
    }


    public List<Nodo> obtenerHijos() {

        Vertice destino;
        List<Nodo> hijos = new ArrayList<>();
        for (int j = 0; j < matriz.devolverDimension(); j++){
            destino = new Vertice(j);
            if ( ! visitados.contains(destino)){
                hijos.add(new Nodo(destino, this));
            }
        }


//        Nodo hijo;
//        for (Arista arista : aristas) {
//            Vertice destino = arista.obtenerDestino();
//            if ( ! visitados.contains(destino)){
//                hijos.add(new Nodo(destino, this));
//            }
//        }
        return hijos;
    }

    public int c_est(){
        int costePadre = padre.costeEstimado ;
        int costeArista = matriz.devolverCoste(padre.vertice, vertice);
        int r = matriz.reducirNodoIntermedio(padre.vertice, vertice);

        costeEstimado =  costePadre + costeArista + r;
        visitados.add(vertice);
        return costeEstimado;
    }

    public int obtenerCosteEstimado(){
        return costeEstimado;
    }

    /**
     * Sera un nodo hoja cuando los visitados sean todos los nodos
     * @return
     */
    public boolean esHoja(){
        return matriz.devolverDimension() == visitados.size();
    }

    public Nodo getPadre(){
        return padre;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        Nodo n2 = (Nodo) o;
        return Integer.compare(costeEstimado, n2.costeEstimado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return costeEstimado == nodo.costeEstimado && Objects.equals(vertice, nodo.vertice) && Objects.equals(padre, nodo.padre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertice, padre, costeEstimado);
    }

    public List<Vertice> obtenerVisitados() {
        return visitados;
    }
}
