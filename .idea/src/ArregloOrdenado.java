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
public int eliminar(String palabra, boolean usarBinaria) {
    int[] resultadoBusqueda = usarBinaria ? busquedaBinaria(palabra) : busquedaLinealOptimizada(palabra);
    int pos = resultadoBusqueda[0];

    if (pos == -1) {
        return -1;
    }
    for (int i = pos; i < n - 1; i++) {
        arreglo[i] = arreglo[i + 1];
    }

    n--;
    return pos;
}
public int modificar(String palabraAntigua, String palabraNueva, boolean usarBinaria) {
    int posEliminada = eliminar(palabraAntigua, usarBinaria);

    if (posEliminada == -1) {
        return -1;
    }
    return insertar(palabraNueva);
}
public void mostrar() {
    if (n == 0) {
        System.out.println("El arreglo está vacío.");
        return;
    }

    System.out.println("--- ELEMENTOS EN EL ARREGLO ---");
    for (int i = 0; i < n; i++) {
        System.out.println("[" + i + "] => " + arreglo[i]);
    }
}
}
