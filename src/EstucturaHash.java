import java.util.Arrays;

public class EstucturaHash {
    String[] Arreglo;
    int tam;

    public EstucturaHash(int tam) {
        this.tam = tam;
        Arreglo = new String[tam];
        Arrays.fill(Arreglo, "-1");  // Inicializar con un valor "-1"
    }

    public void funcionHash(String[] texto) {
        for (String elemento : texto) {
            int indarre = Integer.parseInt(elemento) % tam;
            System.out.println("El índice es: " + indarre + " para el elemento: " + elemento);
            // Resolución de colisiones con sondeo lineal
            while (!Arreglo[indarre].equals("-1")) {
                System.out.println("Ocurrió una colisión en el índice: " + indarre +
                        " Cambiar al índice " + ((indarre + 1) % tam));
                indarre = (indarre + 1) % tam;  // Incremento cíclico del índice
            }
            Arreglo[indarre] = elemento;  // Asignar el elemento en la posición libre
        }
    }

    public void mostrar() {
        System.out.println("Contenido de la tabla hash:");
        System.out.print("Índice: ");
        for (int i = 0; i < tam; i++) {
            System.out.printf("%3d ", i);  // Imprimir índices
        }
        System.out.println();
        System.out.print("Valor: ");
        for (int i = 0; i < tam; i++) {
            System.out.print(Arreglo[i].equals("-1") ? "   - " : String.format("%3s ", Arreglo[i]));  // Imprimir valores
        }
        System.out.println();
    }

    public String buscar(String elemento) {
        int indarre = Integer.parseInt(elemento) % tam;
        int cont = 0;
        while (!Arreglo[indarre].equals("-1")) {
            if (Arreglo[indarre].equals(elemento)) {
                System.out.println("El elemento fue encontrado en el índice: " + indarre);
                return Arreglo[indarre];
            }
            indarre = (indarre + 1) % tam;  // Incremento cíclico del índice
            cont++;
            if (cont == tam) {  // Evitar ciclo infinito
                System.out.println("Elemento no encontrado.");
                break;
            }
        }
        return null;  // Elemento no encontrado
    }
}