import java.util.Arrays;

public class Recorrido {
    Arista[] aristas;
    int coste;

    public Recorrido(Arista[] vertices) {
        this.aristas = vertices;
        calcularCoste();
    }

    private void calcularCoste() {
        int coste = 0;
        for (int i = 0; i < aristas.length; i++) {
            coste += aristas[i].obtenerCoste();
        }

        this.coste = coste;
    }

    public int devolverCoste() {
        return coste;
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