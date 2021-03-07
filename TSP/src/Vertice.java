public class Vertice {
    private int id;
    private char nombre;

    public Vertice(int id) {
        this.id = id;
        nombre = (char) (id+65);
    }

    public int obtenerId() {
        return id;
    }

    public char obtenerNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return ""+ nombre;
    }
}
