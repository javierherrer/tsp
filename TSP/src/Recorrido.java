import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recorrido {
    List<Arista> aristas;
    int coste;

    public Recorrido(){
        aristas = new ArrayList<>();
    }

    // Usado en Fuerza bruta
    public Recorrido(List<Arista> aristas) {
        this.aristas = aristas;
        calcularCoste();
    }

    private void calcularCoste() {
        int coste = 0;

        for (Arista arista: aristas) {
            coste += arista.obtenerCoste();
        }

        this.coste = coste;
    }

    public int devolverCoste() {
        return coste;
    }

    public void añadirArista(Arista arista) {
        aristas.add(arista);
        coste += arista.obtenerCoste();
    }

    //si añadiendo más candidatos se puede llegar a una solución
    public boolean esCompleatable() {
        //TODO

        //solo comprobar si no se han visitado todos los puntos

        return false;
    }

    public

    public int obtenerVisitasVertice(Vertice vertice) {
        int visitas = 0;
        for (Arista arista : aristas) {
            if (arista.contiene(vertice)) {
                visitas++;
            }
        }
        return visitas;
    }

    private void ordenarRecorrido(List<Arista> desordenado){
        int[] orden = new int[desordenado.size()];

    }
    @Override
    public String toString() {
        String cadena = "Coste: " + coste + ", Aristas: { ";
        for (Arista arista : aristas) {
            cadena += arista + " ";
        }
        cadena += "}";

        return cadena;
    }
}