import java.util.List;

/**
 * El algoritmo de fuerza bruta para resolver el problema consiste en intentar
 *  todas las posibilidades, es decir, calcular las longitudes de todos los
 *  recorridos posibles, y seleccionar la de longitud mínima.
 *
 */
public class FuerzaBruta implements AlgoritmoTSP{
    private Matriz matriz;

    public FuerzaBruta(Matriz matriz) {
        this.matriz = matriz;
    }

    public Recorrido resolver() {
        List<Recorrido> recorridos = matriz.devolverRecorridos();
        Recorrido mejorRecorrido = recorridos.get(0);

        for (Recorrido recorrido : recorridos) {
            System.out.println(recorrido);
            if (recorrido.devolverCoste() < mejorRecorrido.devolverCoste()) {
                mejorRecorrido = recorrido;
            }
        }

        return mejorRecorrido;
    }
}
