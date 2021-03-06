import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
// Java program to distinct permutations of the string
public class Permutaciones {
    int elementos;
    Matriz matriz;
    List<Recorrido> lista;

    public Permutaciones(int n, Matriz matriz) {
        this.lista = new ArrayList<>();
        this.matriz = matriz;
        this.elementos = n;
        int[] lista2 = new int[n-1];
        for (int i = 0; i < lista2.length; i++) {
            lista2[i] = i+1;
        }
        printAllRecursive(lista2.length, lista2);

        for (Recorrido rec : lista) {
            System.out.println(rec.toString());
        }

    }

    public void printAllRecursive(int n, int[] elements) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private void printArray(int[] vertices) {
        Arista[] aristas = new Arista[elementos];
        aristas[0] = new Arista(0, vertices[0]);
        int i = 0;
        for(i = 1; i < aristas.length -1; i++) {
            aristas[i] = new Arista(vertices[i-1], vertices[i]);
        }
        aristas[i] = new Arista(vertices[i-1], 0);
        lista.add(new Recorrido(aristas, matriz));
    }


    public static void generate(int k, int[] A, List<int[]> salida) {
        if (k == 1){
            salida.add(Arrays.copyOf(A, A.length));
            System.out.println(Arrays.toString(A));
        } else {
            for (int i = 0; i < k -1; i++){
                generate(k - 1, A, salida);
                if (k%2 == 0){
                    swap2(A, i, k -1);
                } else {
                    swap2(A,0, k -1);
                }
            }
            generate(k - 1, A, salida);

        }
    }

    private static void swap2(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

}
