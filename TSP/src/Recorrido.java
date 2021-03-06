import javax.sound.midi.Receiver;
import java.util.Arrays;

public class Recorrido {
    // Lista de vértices del recorrido
    Arista[] aristas;
    int coste;
    int appendPos;

    public Recorrido(int longitud) {
        this.aristas = new Arista[longitud];
        appendPos = longitud - 1;
    }

    public Recorrido(Arista[] vertices, Matriz matriz) {
        this.aristas = vertices;
//        calcularCoste(matriz);
    }

    private void calcularCoste(Matriz matriz) {
        int coste = 0;
        for (int i = 0; i < aristas.length; i++) {
            coste += matriz.devolverCoste(aristas[i]);
        }

        this.coste = coste;
    }

    public int devolverCoste() {
        return coste;
    }

    @Override
    public String toString() {
        //TODO
        return "Recorrido{" +
                "vertices=" + Arrays.toString(aristas) +
                ", coste=" + coste +
                '}';
    }
}