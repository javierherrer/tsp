import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Funciones auxiliares que emplea el problema
 *
 */
public abstract class FuncionesAuxiliaresTSP {

    /**
     * https://stackoverflow.com/questions/1277880/
     * how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way/1277904
     *
     */
    public static int devolverDimensionMatriz(String fichero)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    /**
     * https://www.tutorialspoint.com/How-to-read-a-2d-array-from-a-file-in-java
     *
     */
    public static int[][] leerMatriz(String fichero, int dim)
            throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fichero)));
        int [][] myArray = new int[dim][dim];
        while(sc.hasNextLine()) {
            for (int i=0; i<myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return myArray;
    }
}
