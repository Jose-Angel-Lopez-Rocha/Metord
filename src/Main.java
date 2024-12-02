import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EstucturaHash estucturaHash = null; // Declarar fuera del bucle
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar el número de posiciones tabla hash");
            System.out.println("2. Agregar elementos a la tabla hash");
            System.out.println("3. Mostrar tabla hash");
            System.out.println("4. Buscar un elemento en la tabla hash");
            System.out.println("5. Búsqueda secuencial");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el número de posiciones para la tabla hash: ");
                    int posi = scanner.nextInt();
                    scanner.nextLine();
                    estucturaHash = new EstucturaHash(posi); // Inicializar la tabla hash
                    break;
                case 2:
                    if (estucturaHash == null) {
                        System.out.println("Primero debes ingresar el tamaño de la tabla hash (opción 1).");
                    } else {
                        System.out.print("Ingresa los elementos a agregar (separados por comas): ");
                        String input = scanner.nextLine();
                        String[] elementos = input.split(",");
                        estucturaHash.funcionHash(elementos);
                    }
                    break;
                case 3:
                    if (estucturaHash == null) {
                        System.out.println("Primero debes ingresar el tamaño de la tabla hash (opción 1).");
                    } else {
                        estucturaHash.mostrar();
                    }
                    break;
                case 4:
                    if (estucturaHash == null) {
                        System.out.println("Primero debes ingresar el tamaño de la tabla hash (opción 1).");
                    } else {
                        System.out.print("Ingresa el número a buscar en la tabla hash: ");
                        String busqueda = scanner.nextLine();
                        String resultado = estucturaHash.buscar(busqueda);
                        if (resultado == null) {
                            System.out.println("Elemento no encontrado.");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingresa los elementos del arreglo separados por comas: ");
                    String[] input = scanner.nextLine().split(",");
                    int[] arreglo = new int[input.length];
                    for (int i = 0; i < input.length; i++) arreglo[i] = Integer.parseInt(input[i]);

                    System.out.print("Ingresa el elemento a buscar: ");
                    int buscado = scanner.nextInt(); // El número que buscamos

                    int resultado = Secuencial.busquedaSecuencial(arreglo, buscado); // Llamada a la búsqueda

                    if (resultado == -1) {
                        System.out.println("Elemento no encontrado");
                    } else {
                        System.out.println("Elemento encontrado en el índice: " + resultado);
                    }
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Ingresala de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
