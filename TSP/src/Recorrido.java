import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    //OPCIONAL Atributo origen
    List<Arista> aristas;
    MatrizAdyacencia matrizAdyacencia;
    int coste;


    public Recorrido(int vertices){
        aristas = new ArrayList<>();
        coste = 0;
        matrizAdyacencia = new MatrizAdyacencia(vertices);
    }

    public Recorrido(List<Arista> aristas, int coste){
        this.aristas = aristas;
        this.coste = coste;
    }

    public int devolverCoste() {
        return coste;
    }

    public void añadirArista(Arista arista) {
        aristas.add(arista);
        coste += arista.obtenerCoste();
        matrizAdyacencia.añadirArista(arista);
    }

    public int obtenerNumAristas() {
        return aristas.size();
    }

    public boolean aristaCumpleRestriccion(Arista arista) {
        Vertice destino = arista.obtenerDestino();
        return ! matrizAdyacencia.existeDestino(destino) &&
                destino.obtenerId() != 0;
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