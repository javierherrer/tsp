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
        return Permutaciones.obtenerPermutaciones(matriz.length, this);
    }


    public int devolverCoste(int desde, int hasta) {
        return matriz[desde][hasta];
    }



}
