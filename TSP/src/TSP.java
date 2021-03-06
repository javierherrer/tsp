import java.util.*;

/**
 * Ejecución del programa, captura de parámetros y llamada al algoritmo correspondiente
 *
 */
public class TSP {
    private static final int NUM_ARGS = 2;
    private static final int DIM_POR_DEFECTO = 3;
    private static final String ERROR_SINTAXIS = "La forma de ejecución es:\n" +
            "\thendrix:~/ tsp -opt <nombre de fichero>\n" +
            "donde opt es la cadena fb, av, pd o rp que indica el " +
            "esquema (fuerza bruta, algoritmo voraz, programación dinámica o " +
            "ramificación y poda) a utilizar, y <nombre de fichero> es el " +
            "nombre de un fichero de texto con las distancias entre vértices " +
            "en forma matricial.";
    private static final String OPCION_FUERZA_BRUTA = "-fb";
    private static final String OPCION_ALGORITMO_VORAZ = "-av";

    static public void main(String[] args) {
        test("tspbenchmarks\\a11.tsp");

        if (args.length != NUM_ARGS) {
            System.out.println(ERROR_SINTAXIS);
        } else {
            AlgoritmoTSP algoritmo = null;
            String opcion = args[0];
            String fichero = args[1];
            Matriz matriz = new Matriz(fichero);

            switch(opcion) {
                case OPCION_FUERZA_BRUTA:
                    algoritmo = new FuerzaBruta(matriz);
                    break;
                case OPCION_ALGORITMO_VORAZ:
                    algoritmo = new AlgoritmoVoraz();
                    break;
                default:
                    System.out.println(ERROR_SINTAXIS);
                    break;
            }

            long time = System.currentTimeMillis();
            Recorrido solucion = algoritmo.resolver();
            time = System.currentTimeMillis() - time;

            System.out.println("Tiempo: " + time);
            System.out.println(solucion);
        }

    }

    static public void test(String fichero){
        Matriz matriz = new Matriz(fichero);
        new Permutaciones(4, matriz);

//        List<Recorrido> permutaciones = matriz.devolverRecorridos();
//
//        for (Recorrido r : permutaciones){
//            System.out.println(r);
//        }
    }
}
