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

    public Matriz(Matriz matriz){
        int dim = matriz.devolverDimension();
        int[][] nuevaMatriz = new int[dim][];
        for( int i = 0; i < dim; i++){
            nuevaMatriz[i] = Arrays.copyOf(matriz.matriz[i], dim);
        }
        this.matriz = nuevaMatriz;
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
     * Reduce la matriz para que todas las columnas y filas
     * contengan un 0
     * Devuelve la cantidad L total reducida
     */
    public int reducirMatriz(){
        int L = 0;

        for (int i = 0; i< this.devolverDimension(); i++) {
            L += reducirFila(i);
        }

        for (int i = 0; i< this.devolverDimension(); i++) {
            L += reducirColumna(i);
        }

        return L;
    }

    public int reducirNodoIntermedio(Vertice verticeOrigen, Vertice verticeDestino){
        int origen = verticeOrigen.obtenerId();
        int destino = verticeDestino.obtenerId();

        for (int i = 0; i< this.devolverDimension(); i++) {
            matriz[origen][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i< this.devolverDimension(); i++) {
            matriz[i][destino] = Integer.MAX_VALUE;
        }

        // Cambiar elemento A(j,1) = Inf
        matriz[destino][0] = Integer.MAX_VALUE;
        return reducirMatriz();

    }

    public void diagonalInfinitos(){
        for (int i = 0; i< this.devolverDimension(); i++) {
            matriz[i][i] = Integer.MAX_VALUE;
        }
    }
    /**
     * Comprueba si la fila tiene un cero y la reduce en caso contrario
     * Devuelve el valor por el cual se ha reducido, si ya era una fila
     * reducida, devuelve 0
     */
    private int reducirFila(int fila){
        int minValor = Integer.MAX_VALUE;
        int valor;
        for (int i = 0; i < this.devolverDimension(); i++) {

            valor = matriz[fila][i];

            if (valor < minValor) {
                minValor = valor;
            }
            if (valor == 0){
                return minValor;
            }
        }
        for (int i = 0; i< this.devolverDimension(); i++) {
            if(matriz[fila][i] != Integer.MAX_VALUE){
                matriz[fila][i] -= minValor;
            }
        }
        if (minValor == Integer.MAX_VALUE){
            return 0;
        }
        return minValor;
    }

    /**
     * Comprueba si la columna tiene un cero y la reduce en caso contrario
     * Devuelve el valor por el cual se ha reducido, si ya era una columna
     * reducida, devuelve 0
     */
    private int reducirColumna(int columna){
        int minValor = Integer.MAX_VALUE;
        int valor;

        for (int i = 0; i < this.devolverDimension(); i++) {
            valor = matriz[i][columna];
            if (valor < minValor) {
                minValor = valor;
            }
            if (valor == 0){
                return minValor;
            }
        }

        for (int i = 0; i< this.devolverDimension(); i++) {
            if(matriz[i][columna] != Integer.MAX_VALUE) {
                matriz[i][columna] -= minValor;
            }
        }
        if (minValor == Integer.MAX_VALUE){
            return 0;
        }
        return minValor;
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

//    /**
//     * Devuelve las parejas ordenadas desde un vértice por distancia creciente
//     *  entre sus puntos
//     *
//     */
//    public List<Vertice> obtenerVerticesDesde(Vertice desde) {
//        ArrayList<Vertice> vertices = new ArrayList<>();
//
//        int i = desde.obtenerId();
//        for (int j = 0; j < this.matriz[0].length; j++){
//            vertices.add(new Vertice(j));
//        }
//
//        return v;
//    }

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
