public class Vertice {
    public int id;
    private String nombre;

    public Vertice(int id) {
        this.id = id;
    }

    public String devolverNombre() {
        //TODO
        return null;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "id=" + id +
                '}';
    }
}
