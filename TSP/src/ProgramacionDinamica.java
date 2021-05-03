import java.util.ArrayList;
import java.util.List;

public class ProgramacionDinamica implements AlgoritmoTSP {
    private static Matriz matriz;
    private static Vertice origen;
    private static List<Vertice> S;
    private static GTab gtab;

    public ProgramacionDinamica(Matriz matriz) {
        this.matriz = matriz;
        origen = new Vertice(0);
        S = new ArrayList<>();
        gtab = new GTab();
    }

    /**
     * Calcular g para todos los conjuntos S con un solo vsrtice
     *  (distinto de 1).
     * Calcular g para todos los conjuntos S de dos vertices (distintos de 1)
     *  y asi sucesivamente.
     * Cuando se conoce el valor de g para todos los conjuntos S a los que solo
     *  les falta un vertice (distinto de 1) basta con calcular g(1, V\{1}).
     *
     */
    public Recorrido resolver() {
        return null;
    }

    /**
     * g(i,S): longitud del camino mínimo desde i hasta 1 que pase exactamente
     *         una vez por cada vértice de S.
     *
     */
    private static int g(Vertice i, List<Vertice> S) {
        int masCorto = Integer.MAX_VALUE;
        int distancia = 0;
        int valorGtab = 0;
        List<Vertice> nuevaS = new ArrayList<>();

        if (S.isEmpty()) {
            return matriz.devolverCoste(i, origen);
        } else {
            valorGtab = gtab.devolverCoste(i, S);
            if ( valorGtab == GTab.VALOR_NO_CALCULADO ) {
                for (Vertice j : S) {
                    nuevaS = new ArrayList<>(S);
                    nuevaS.remove(j);
                    distancia = matriz.devolverCoste(i,j) + g(j, nuevaS);
                    if ( distancia < masCorto ) {
                        masCorto = distancia;
                    }
                }
                gtab.guardarCoste(i, S, masCorto);
                return masCorto;
            } else {
                return valorGtab;
            }
        }
    }

}
