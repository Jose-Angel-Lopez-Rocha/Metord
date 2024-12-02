public class Secuencial {
    public static int busquedaSecuencial(int[] v, int buscado) {
        boolean encontrado = false;
        int i = 0;

        // Búsqueda secuencial
        while (i <= v.length - 1 && !encontrado) {
            if (buscado == v[i]) { // Comparar el elemento buscado con el actual
                encontrado = true;
            } else {
                i++; // Avanzar al siguiente elemento
            }
        }

        // Retornar el índice si se encontró, o -1 si no
        if (encontrado) {
            return i;
        } else {
            return -1;
        }
    }
}
