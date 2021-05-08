import java.util.*;

public class GTab {
    public static final int VALOR_NO_CALCULADO = -1;
    // TODO: Colección que almacene para cada vértice, todos los subconjuntos
    //        posibles de los n vértices
    // Opciones: Propuesta por JFields representación mediante bits
    //           Algo de alto nivel, con un HashSet por ejemplo.

    // Guardamos la distancia desde el vertice hasta el origen con distancia K
    // Se pueden ir borrando las distancias anteriores sin usar, K - 2 por ejemplo
    private Map<Vertice, Map<Set<Vertice>, Integer>> g;

    public GTab(Matriz matriz) {
        //TODO: inicializar la estructura de datos
        //TODO: guardar los costes de todas las aristas con destino el vértice
        //       inicial. g(i, <conjuntoVacio>) para todo i.
        g = new HashMap<>();
        List<Arista> aristas = matriz.obtenerAristasHasta(0);

        for (Arista a : aristas) {
            int coste = a.obtenerCoste();
            Vertice origen = a.obtenerOrigen();
            Set<Vertice> camino = new HashSet<>();
            guardarCoste(origen,camino, coste);
        }

    }

    /**
     * Devuelve el coste si ha sido guardado previamente.
     * Si no, devuelve VALOR_NO_CALCULADO.
     *
     */
    public int devolverCoste (Vertice i, Set<Vertice> S) {
        Map<Set<Vertice>, Integer> camino  = g.get(i);
        Integer coste = camino.get(S);

        if (coste == null){

            return VALOR_NO_CALCULADO;
        }
        return coste;
    }

    // Es ya coste mínimo?
    // Si coste es mínimo, se puede borrar el coste para S.size()-1
    public void guardarCoste (Vertice i, Set<Vertice> S, int coste) {
        Map<Set<Vertice>, Integer> camino = new HashMap<>();
        camino.put(S, coste);
        g.put(i, camino);
    }
}
