import java.util.List;

/**
 * El algoritmo voraz para resolver el problema consistene en ir seleccionando
 *  todas las parejas de puntos que serán visitados de forma consecutiva:
 *  - Se seleccionará primero aquella pareja de puntos entre los que la
 *    distancia sea mínima;
 *  - a continuación, se selecciona la siguiente pareja separada con una
 *     distancia mínima siempre que esta nueva elección no haga que:
 *     * se visite un punto dos veces o más, o
 *     * se cierre un recorrido antes de haber visitado todos los puntos.
 */
public class AlgoritmoVoraz implements AlgoritmoTSP {
    private Matriz matriz;

    public AlgoritmoVoraz(Matriz matriz) {
        this.matriz = matriz;
    }

    /**
     * Solución basada en el algoritmo de Kruscal
     *
     */
    public Recorrido resolver() {
        int vertices = matriz.devolverDimension();
        Recorrido solucion = new Recorrido(vertices);
        int i = 0;

        Vertice origen = new Vertice(0);
        List<Arista> aristas = matriz.obtenerAristasDesde(origen);
        Arista arista = aristas.get(i);
        solucion.añadirArista(arista);

        while (solucion.obtenerNumAristas() < vertices - 1) {
            Vertice ultimoVertice = arista.obtenerDestino();
            aristas = matriz.obtenerAristasDesde(ultimoVertice);
            i = 0;
            do {
                arista = aristas.get(i);
                i++;
            } while (! solucion.aristaCumpleRestriccion(arista));
            solucion.añadirArista(arista);
        }
        int desde = arista.obtenerDestino().obtenerId();
        arista = new Arista(desde, 0, matriz.devolverCoste(desde, 0));
        solucion.añadirArista(arista);

        return solucion;
    }
}
