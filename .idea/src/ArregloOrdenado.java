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
public int[] busquedaBinaria(String palabra) {
    int inicio = 0;
    int fin = n - 1;
    int ciclos = 0;

    while (inicio <= fin) {
        ciclos++;
        int medio = inicio + (fin - inicio) / 2;
        int comparacion = arreglo[medio].compareToIgnoreCase(palabra);

        if (comparacion == 0) {
            return new int[]{medio, ciclos};
        }
        if (comparacion < 0) {
            inicio = medio + 1;
        } else {
            fin = medio - 1;
        }
    }
    return new int[]{-1, ciclos};
}
public int insertar(String palabra) {
    if (estaLleno()) {
        return -1;
    }
    int i = n - 1;
    while (i >= 0 && arreglo[i].compareToIgnoreCase(palabra) > 0) {
        arreglo[i + 1] = arreglo[i];
        i--;
    }

    int posInsertada = i + 1;
    arreglo[posInsertada] = palabra;
    n++;
    return posInsertada;
}
