public class MatrizAdyacencia {
    private boolean[][] matriz;

    public MatrizAdyacencia(int vertices) {
        matriz = new boolean[vertices][vertices];
    }

    /**
     * Devuelve verdad si el vertice es destino de una arista ya existente.
     * @param destino
     * @return
     */
    public boolean existeDestino(Vertice destino) {
        int i = 0;
        int j = destino.obtenerId();
        while (i < matriz.length) {
            if (matriz[i][j]) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Asigna un valor de verdad en la posición correspondiente
     * @param arista
     */
    public void añadirArista(Arista arista) {
        Vertice desde = arista.obtenerOrigen();
        Vertice hasta = arista.obtenerDestino();
        matriz[desde.obtenerId()][hasta.obtenerId()] = true;
    }
}
