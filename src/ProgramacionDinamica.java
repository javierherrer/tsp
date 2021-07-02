import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgramacionDinamica implements AlgoritmoTSP {
    private static Matriz matriz;
    private static Vertice origen;
    private static Set<Vertice> S;
    private static GTab gtab;
    //Se puede sustituir por Recorrido si se cambia la parte de mat de ady

    public ProgramacionDinamica(Matriz matriz) {
        this.matriz = matriz;
        origen = new Vertice(0);
        S = new HashSet<>();
        gtab = new GTab(matriz);
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
        List<Arista> recorrido;
        int longitud = 0;
        Set<Vertice> S = matriz.devolverVertices();
        S.remove(origen);

        longitud = g(origen, S);

        recorrido = devolverRecorrido(S);
        return new Recorrido(recorrido, longitud);
    }

    private List<Arista> devolverRecorrido(Set<Vertice> S) {
        List<Arista> recorrido = new ArrayList<>();
        Vertice vertice = origen;
        Vertice nuevoVertice;
        Arista arista;

        do {
            nuevoVertice = gtab.devolverJ(vertice, S);
            arista = new Arista(vertice, nuevoVertice);

            recorrido.add(arista);

            S.remove(nuevoVertice);
            vertice = nuevoVertice;
        } while (! S.isEmpty());

        arista = new Arista(vertice, origen);
        recorrido.add(arista);

        return recorrido;
    }

    /**
     * g(i,S): longitud del camino manimo desde i hasta 1 que pase exactamente
     *         una vez por cada vartice de S.
     *
     */
    private static int g(Vertice i, Set<Vertice> S) {
        int masCorto = Integer.MAX_VALUE;
        Tupla tupla = new Tupla(masCorto);
        int distancia = 0;
        int valorGtab = 0;
        Set<Vertice> nuevaS;

        if (S.isEmpty()) {
            return matriz.devolverCoste(i, origen);
        } else {
            valorGtab = gtab.devolverCoste(i, S);
            if ( valorGtab == GTab.VALOR_NO_CALCULADO ) {
                for (Vertice j : S) {
                    nuevaS = new HashSet<>(S);
                    nuevaS.remove(j);
                    distancia = matriz.devolverCoste(i,j) + g(j, nuevaS);
                    if ( distancia < masCorto ) {
                        masCorto = distancia;
                        tupla = new Tupla(masCorto, j);
                    }
                }
                gtab.guardarCoste(i, S, tupla);
                return masCorto;
            } else {
                return valorGtab;
            }
        }
    }
}
