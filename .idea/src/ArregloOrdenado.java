public class ArregloOrdenado {
    private String[] arreglo;
    private int n;
    private final int MAX_CAPACIDAD = 20;

    public ArregloOrdenado() {
        this.arreglo = new String[MAX_CAPACIDAD];
        this.n = 0;
    }

    public void inicializar() {
        this.n = 0;
    }

    public int getCantidadElementos() {
        return n;
    }

    public boolean estaLleno() {
        return n >= MAX_CAPACIDAD;
    }
}
