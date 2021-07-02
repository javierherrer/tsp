import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return id == vertice.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
