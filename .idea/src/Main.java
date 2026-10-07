import java.util.Scanner;

public class Main {
        private static Scanner scanner = new Scanner(System.in);
        private static ArregloOrdenado arreglo = new ArregloOrdenado();

        public static void main(String[] args) {
                int opcion;
        }


                do {       
                        limpiarPantalla();  
                        System.out.println("      MENÚ - ARREGLOS ORDENADOS");
                        System.out.println("1. Inicializar / Borrar arreglo");
                        System.out.println("2. Mostrar Arreglo");
                        System.out.println("3. Buscar palabra");
                        System.out.println("4. Insertar palabra");
                        System.out.println("5. Eliminar palabra");
                        System.out.println("6. Modificar palabra");
                        System.out.println("7. Créditos");
                        System.out.println("8. Salir");
                        System.out.println("==========================================");
                        System.out.print("Seleccione una opción: ");

                        try {
                                opcion = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                                opcion = 0;
                        }

                       } switch (opcion) {
                case 1:
                        arreglo.inicializar();
                        System.out.println("\nSe ha reiniciado el arreglo (borrado lógico realizado).");
                        pausa();
                        break;

                case 2:
                        System.out.println();
                        arreglo.mostrar();
                        pausa();
                        break;

                case 3:
                        opcionBuscar();
                        pausa();
                        break;

                case 4:
                        opcionInsertar();
                        pausa();
                        break;

                case 5:
                        opcionEliminar();
                        pausa();
                        break;

                case 6:
                        opcionModificar();
                        pausa();
                        break;

                case 7:
                        mostrarCreditos();
                        pausa();
                        break;

                case 8:
                        System.out.println("\n¡Programa finalizado exitosamente!");
                        break;

                default:
                        System.out.println("\nOpción no válida. Intente nuevamente.");
                        pausa();
                        break;
        }

} while (opcion != 8);
        }

private static void opcionBuscar() {
        if (arreglo.getCantidadElementos() == 0) {
                System.out.println("\nEl arreglo está vacío. No hay nada que buscar.");
                return;
        }

        System.out.print("\nIngrese la palabra a buscar: ");
        String palabra = scanner.nextLine();

        System.out.println("Elija el algoritmo de búsqueda:");
        System.out.println("1. Búsqueda Lineal Optimizada");
        System.out.println("2. Búsqueda Binaria");
        System.out.print("Opción: ");
        int metodo = 1;
        try {
                metodo = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}

        int[] resultado;
        if (metodo == 2) {
                resultado = arreglo.busquedaBinaria(palabra);
        } else {
                resultado = arreglo.busquedaLinealOptimizada(palabra);
        }

        int posicion = resultado[0];
        int ciclos = resultado[1];

        if (posicion != -1) {
                System.out.println("\nPalabra '" + palabra + "' ENCONTRADA en la localidad: " + posicion);
        } else {
                System.out.println("\nLa palabra '" + palabra + "' NO EXISTE en el arreglo.");
        }
        System.out.println("Número de ciclos requeridos para la operación: " + ciclos);
}

private static void opcionInsertar() {
        if (arreglo.estaLleno()) {
                System.out.println("\nError: El arreglo está lleno (límite de 20 palabras alcanzado).");
                return;
        }

        System.out.print("\nIngrese la palabra a insertar: ");
        String palabra = scanner.nextLine();

        int pos = arreglo.insertar(palabra);
        System.out.println("Palabra '" + palabra + "' insertada correctamente en la localidad: " + pos);
}

private static void opcionEliminar() {
        if (arreglo.getCantidadElementos() == 0) {
                System.out.println("\nEl arreglo está vacío.");
                return;
        }

        System.out.print("\nIngrese la palabra a eliminar: ");
        String palabra = scanner.nextLine();

        boolean usarBinaria = seleccionarTipoBusqueda();
        int pos = arreglo.eliminar(palabra, usarBinaria);

        if (pos != -1) {
                System.out.println("Palabra eliminada correctamente de la localidad: " + pos);
        } else {
                System.out.println("No se pudo localizar la palabra. Por lo tanto, no procede la operación.");
        }
}

private static void opcionModificar() {
        if (arreglo.getCantidadElementos() == 0) {
                System.out.println("\nEl arreglo está vacío.");
                return;
        }

        System.out.print("\nIngrese la palabra a modificar: ");
        String palabraAntigua = scanner.nextLine();

        boolean usarBinaria = seleccionarTipoBusqueda();

        int[] res = usarBinaria ? arreglo.busquedaBinaria(palabraAntigua) : arreglo.busquedaLinealOptimizada(palabraAntigua);
        if (res[0] == -1) {
                System.out.println("No se pudo localizar la palabra a modificar. Operación cancelada.");
                return;
        }

        System.out.print("Ingrese la nueva palabra reemplazante: ");
        String palabraNueva = scanner.nextLine();

        int posNueva = arreglo.modificar(palabraAntigua, palabraNueva, usarBinaria);
        System.out.println("Palabra modificada. Ahora quedó guardada en la localidad: " + posNueva);
}

private static boolean seleccionarTipoBusqueda() {
        System.out.println("Seleccione tipo de búsqueda interna:");
        System.out.println("1. Lineal Optimizada");
        System.out.println("2. Binaria");
        System.out.print("Opción (por defecto 1): ");
        try {
                int op = Integer.parseInt(scanner.nextLine());
                return op == 2;
        } catch (Exception e) {
                return false;
        }
}

private static void mostrarCreditos() {
        System.out.println("                CRÉDITOS");
        System.out.println("==========================================");
        System.out.println("Materia: Estructuras de Datos");
        System.out.println("Integrantes del Equipo:");
        System.out.println(" - Nombre 1 - Matrícula: 12345678");
        System.out.println(" - Nombre 2 - Matrícula: 87654321");
}

private static void pausa() {
        System.out.print("\nPresione [ENTER] para regresar al menú principal...");
        scanner.nextLine();
}

private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
}
