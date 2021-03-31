import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmo de Heap
 * https://es.wikipedia.org/wiki/Algoritmo_de_Heap
 */
public class Permutaciones {

    public static List<Recorrido> recorridos;

    public static List<Recorrido> obtenerPermutaciones(int n, Matriz matriz) {
        int[] verticesAPermutar = new int[n-1];
        recorridos = new ArrayList<>();
        for (int i = 0; i < verticesAPermutar.length; i++) {
            verticesAPermutar[i] = i+1;
        }
        printAllRecursive(n-1, verticesAPermutar, matriz);
        return recorridos;
    }

    private static void printAllRecursive(int n, int[] elements,
                                          Matriz matriz) {
        Arista[] aristas;

        if(n == 1) {
            aristas = obtenerAristas(elements, matriz);
            recorridos.add(new Recorrido(aristas));
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, matriz);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, matriz);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static Arista[] obtenerAristas(int[] vertices, Matriz matriz) {
        Arista[] aristas = new Arista[vertices.length + 1];
        int i = 0;

        int desde = 0;
        int hasta = vertices[0];
        aristas[i] = new Arista(desde, hasta,
                                matriz.devolverCoste(desde, hasta));

        for(i = 1; i < aristas.length -1; i++) {
            desde = vertices[i-1];
            hasta = vertices[i];
            aristas[i] = new Arista(desde, hasta,
                                    matriz.devolverCoste(desde, hasta));
        }

        desde = vertices[i-1];
        hasta = 0;
        aristas[i] = new Arista(desde, hasta,
                                matriz.devolverCoste(desde, hasta));

        return aristas;
    }
}
