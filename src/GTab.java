import java.util.*;

public class GTab {
    public static final int VALOR_NO_CALCULADO = -1;
    // Guardamos la distancia desde el vertice hasta el origen con distancia K
    // Se pueden ir borrando las distancias anteriores sin usar, K - 2 por ejemplo
    private Map<Vertice, Map<Set<Vertice>, Tupla>> g;

    public GTab(Matriz matriz) {
        g = new HashMap<>();
    }

    /**
     * Devuelve el coste si ha sido guardado previamente.
     * Si no, devuelve VALOR_NO_CALCULADO.
     *
     */
    public int devolverCoste (Vertice i, Set<Vertice> S) {
        Map<Set<Vertice>, Tupla> camino  = g.get(i);
        if (camino == null){
            return VALOR_NO_CALCULADO;
        }

        Tupla coste = camino.get(S);

        if (coste == null){

            return VALOR_NO_CALCULADO;
        }
        return coste.g;
    }

    /**
     * Devuelve J si ha sido guardado previamente.
     * Si no, devuelve null.
     *
     */
    public Vertice devolverJ (Vertice i, Set<Vertice> S) {
        Map<Set<Vertice>, Tupla> camino  = g.get(i);
        if (camino == null){
            return null;
        }

        Tupla coste = camino.get(S);

        if (coste == null){
            return null;
        }
        return coste.j;
    }

    public void guardarCoste (Vertice i, Set<Vertice> S, Tupla coste) {
        Map<Set<Vertice>, Tupla> costes = g.get(i);
        if (costes == null){
            costes = new HashMap<>();
            g.put(i, costes);
        }
        costes.put(S, coste);
    }
}
