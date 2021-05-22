import java.util.*;

public class RamificacionYPoda implements AlgoritmoTSP  {
    private Matriz matriz;
    private Vertice origen;

    private PriorityQueue<Nodo> q;
    private int valorOptimo = Integer.MAX_VALUE;


    public RamificacionYPoda(Matriz matriz){
        q = new PriorityQueue<>();
        this.matriz = matriz;
        origen = new Vertice(0);
    }


    @Override
    public Recorrido resolver() {
        int coste;
        matriz.diagonalInfinitos();
        int L = matriz.reducirMatriz();
        Nodo inicial = new Nodo(origen, matriz, L);

        q.add(inicial);
        Nodo enCurso;
        List<Nodo> hijos;
        Nodo ultimoHijo = null;
        while ( ! q.isEmpty()){
            enCurso = q.remove();
            hijos = enCurso.obtenerHijos();
            for (Nodo hijo : hijos){
                int cest = hijo.c_est();
                if ( cest <= valorOptimo){
                    q.add(hijo);
                    if (hijo.esHoja() && cest < valorOptimo){
                        valorOptimo = cest;
                        ultimoHijo = hijo;
                    }
                }
            }

            if (q.isEmpty() || q.peek().costeEstimado >= valorOptimo){
                // Se ha encontrado solucion
                System.out.println("Encontrada");
                return crearRecorrido(ultimoHijo);
            }

        }

        return null;
    }

    private Recorrido crearRecorrido(Nodo ultimoHijo){
        List<Vertice> vertices = ultimoHijo.obtenerVisitados();
        List<Arista>  aristas = new ArrayList<>();

        Vertice vertice = vertices.get(0);
        Vertice nuevoVertice = null;
        Arista arista = null;
        for (int i = 1; i < vertices.size(); i ++) {
            nuevoVertice = vertices.get(i);
            arista = new Arista(vertice, nuevoVertice);
            aristas.add(arista);
            vertice = nuevoVertice;
        }
        arista = new Arista(vertice, origen);
        aristas.add(arista);


        return new Recorrido(aristas, ultimoHijo.obtenerCosteEstimado());
    }
}