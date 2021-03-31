import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Recorrido resolver() {
        Map<Integer, Integer> aux = new HashMap<>();
        List<Arista> aristas = matriz.devolverAristas();
        Recorrido recorrido = new Recorrido();

        Recorrido candidatos;
        Recorrido escogidos;

        for (Aristas arista : parejas) {
            candidatos.añadirArista(arista);

            if(candidatos.obtenerVisitasVertice() < 3 && candidatos.esCompletable()) {
                escogidos.add(arista);
            } else {
                candidatos.delete(arista);
            }
        }


        int origen;
        int destino;
        int nVisitasDestino;
        int nVisitasOrigen;

        for (Arista arista : aristas) {
            origen = arista.devolverOrigen();
            destino = arista.devolverDestino();

            nVisitasOrigen = aux.getOrDefault(origen, 0);
            nVisitasDestino = aux.getOrDefault(destino, 0);

            // Si no se ha visitado 2 veces
            if(nVisitasOrigen < 2 && nVisitasDestino < 2){
                recorrido.añadirArista(arista);
                if (aristas.size() < matriz.devolverDimension()){

                }

                // Actualizamos el número de visitas
                nVisitasDestino++;
                nVisitasOrigen++;
                aux.put(origen, nVisitasOrigen);
                aux.put(destino, nVisitasDestino);
            }
            if(aristas.size() == matriz.devolverDimension()){
                break;
            }
        }

        //TODO ordenar el recorrido
        return recorrido;
    }
}
