import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class GTab {
    public static final int VALOR_NO_CALCULADO = -1;
    // TODO: Colección que almacene para cada vértice, todos los subconjuntos
    //        posibles de los n vértices
    // Opciones: Propuesta por JFields representación mediante bits
    //           Algo de alto nivel, con un HashSet por ejemplo.

    // Guardamos la distancia desde el vertice hasta el origen con distancia K
    // Se pueden ir borrando las distancias anteriores sin usar, K - 2 por ejemplo
    HashMap<Vertice, HashMap<Integer, Long>> g = new HashMap<>();


    /**
     * Devuelve el coste si ha sido guardado previamente.
     * Si no, devuelve VALOR_NO_CALCULADO.
     *
     */
    public int devolverCoste (Vertice i, List<Vertice> S) {
        Long coste  = g.get(i).get(S.size());
        if (coste == null){

            return VALOR_NO_CALCULADO;
        }
        return coste.intValue();
    }

    // Es ya coste mínimo?
    // Si coste es mínimo, se puede borrar el coste para S.size()-1
    public void guardarCoste (Vertice i, List<Vertice> S, long coste) {
        g.get(i).put(S.size(), coste);
    }
}
