import javax.sound.midi.Receiver;
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

    /**
     * https://stackoverflow.com/questions/1277880/
     * how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way/1277904
     *
     */
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
        //TODO
//        int[] indices = new int[matriz.length];
//        for (int i = 0; i < indices.length; i++){
//            indices[i] = i;
//        }
//        List<Recorrido> recorridos = new ArrayList<>();
//        permutar2(recorridos, indices);
//        return recorridos;
        return null;
    }




//    //    0 10 15 20
//    //    5  0  9 10
//    //    6 13  0 12
//    //    8  8  9  0
//    // Vector es un array de indices
//    public void permutar(List<List<Arista>> permutaciones, int[] vector) {
//        // Caso base
//        if(vector.length == 2){
//            Arista arista;
//            LinkedList<Arista> recorrido = new LinkedList<>();
//            // Añado la primera posibilidad
//            int origen = vector[0];
//            int destino = vector[1];
//            arista = new Arista(origen, destino, devolverCoste(origen, destino));
//
//            recorrido.addLast(arista);
//            permutaciones.add(recorrido);
//            // Añado la otra permutacion
//            recorrido = new LinkedList<>();
//            arista = new Arista(destino, origen, devolverCoste(origen, destino));
//
//            recorrido.addLast(arista);
//            permutaciones.add(recorrido);
//
//        } else {
//            int origen = vector[0]; // <-- Primer vertice
//            int[] subArray = Arrays.copyOfRange(vector, 1, vector.length);
//
//            permutar(permutaciones, subArray); // <-- Permutaciones
//            for (List<Arista> recorrido: permutaciones) {
//
//                LinkedList<Arista> list = (LinkedList<Arista>)recorrido;
//                int destino = list.getFirst().origen;
//                list.addFirst(new Arista(origen, destino, devolverCoste(origen, destino)));
//            }
//        }
//    }
//
//    public void permutar2(List<Recorrido> permutaciones, int[] vector) {
//        // Caso base
//        if(vector.length == 2){
//            Arista arista;
//            Recorrido r  = new Recorrido(matriz.length);
//            // Añado la primera posibilidad
//            int origen = vector[0];
//            int destino = vector[1];
//            arista = new Arista(origen, destino, devolverCoste(origen, destino));
//
//            r.appendArista(arista);
//            permutaciones.add(r);
//            // Añado la otra permutacion
//             r  = new Recorrido(matriz.length);
//            arista = new Arista(destino, origen, devolverCoste(origen, destino));
//
//            r.appendArista(arista);
//            permutaciones.add(r);
//
//        } else {
//            int origen = vector[0]; // <-- Primer vertice
//            int[] subArray = Arrays.copyOfRange(vector, 1, vector.length);
//            List<Recorrido> nuevosRecorridos = new ArrayList<>();
//
//            permutar2(permutaciones, subArray); // <-- Permutaciones
//            for (Recorrido recorrido: permutaciones) {
//
//            }
//        }
//    }


    private int devolverCoste(Vertice desde, Vertice hasta) {
        return matriz[desde.id][hasta.id];
    }

    public int devolverCoste(Arista arista) {
        return devolverCoste(arista.origen, arista.destino);
    }


}
