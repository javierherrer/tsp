public class Tupla {
    // valor de g(i,S)
    public int g;
    // J(i,S) es el valor de j que minimiza g(i,S).
    public Vertice j;

    public Tupla(int g, Vertice j) {
        this.g = g;
        this.j = j;
    }

    public Tupla(int g) {
        this.g = g;
    }
}
