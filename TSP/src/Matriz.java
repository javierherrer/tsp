import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Matriz {

    private int[][] matriz;

    public Matriz(String fichero) {
        try {
            matriz = leerMatriz(fichero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int devolverDimensionMatriz(String fichero)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    private int[][] leerMatriz(String fichero) throws Exception {
        int dim = devolverDimensionMatriz(fichero);
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fichero)));
        Scanner lineScanner;
        int[][] myArray = new int[dim][dim];
        int i = 0;
        while(sc.hasNextLine()) {
            int j = 0;
            lineScanner = new Scanner(sc.nextLine());

            while (lineScanner.hasNext()) {
                myArray[i][j] = lineScanner.nextInt();
                j++;
            }
            i++;
        }
        return myArray;
    }

    /**
     * Devuelve una lista con todos los recorridos posibles
     *
     */
    public List<Recorrido> devolverRecorridos() {
        return Permutaciones.obtenerPermutaciones(matriz.length, this);
    }

    /**
     * Devuelve las parejas ordenadas por distancia creciente entre sus puntos
     *
     */
    public List<Arista> devolverAristas() {
        ArrayList<Arista> aristas = new ArrayList<>();
        //TODO
        for (int i = 0; i < this.matriz[0].length; i++){
            for (int j = 0; j < this.matriz[0].length; j++){
                if (matriz[i][j] != 0){
                    aristas.add(new Arista(i, j, matriz[i][j] ));
                }
            }
        }
        Collections.sort(aristas);
        return aristas;
    }

    /**
     * Devuelve los vértices
     *
     */
    public Set<Vertice> devolverVertices() {
        Set<Vertice> vertices = new HashSet<>();
        for (int i = 0; i < this.matriz[0].length; i++) {
            vertices.add(new Vertice(i));
        }
        return vertices;
    }

    /**
     * Devuelve las parejas ordenadas desde un vértice por distancia creciente
     *  entre sus puntos
     *
     */
    public List<Arista> obtenerAristasDesde(Vertice desde) {
        ArrayList<Arista> aristas = new ArrayList<>();

        int i = desde.obtenerId();
        for (int j = 0; j < this.matriz[0].length; j++){
            if (matriz[i][j] != 0){
                aristas.add(new Arista(i, j, matriz[i][j] ));
            }
        }

        Collections.sort(aristas);
        return aristas;
    }

    /**
     * Devuelve las aristas hasta un vertice
     *
     */
    public List<Arista> obtenerAristasHasta(int hasta) {
        ArrayList<Arista> aristas = new ArrayList<>();

        for (int j = 0; j < this.matriz[0].length; j++){
            if (matriz[j][hasta] != 0){
                aristas.add(new Arista(j, hasta, matriz[j][hasta] ));
            }
        }

        return aristas;
    }

    public int devolverCoste(int desde, int hasta) {
        return matriz[desde][hasta];
    }

    public int devolverCoste(Vertice desde, Vertice hasta) {
        return matriz[desde.obtenerId()][hasta.obtenerId()];
    }

    public int devolverDimension() {
        return matriz[0].length;
    }
}
