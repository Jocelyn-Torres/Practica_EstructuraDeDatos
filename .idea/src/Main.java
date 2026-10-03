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

                       }