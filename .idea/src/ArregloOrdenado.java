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
    public int[] busquedaLinealOptimizada(String palabra) {
        int ciclos = 0;
        for (int i = 0; i < n; i++) {
            ciclos++;
            int comparacion = arreglo[i].compareToIgnoreCase(palabra);
            if (comparacion == 0) {
                return new int[]{i, ciclos};
            }
            if (comparacion > 0) {
                break;
            }
        }
        return new int[]{-1, ciclos};
    }
