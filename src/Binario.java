public class Binario {
    int busquedaBinaria(int[] elementos, int x)
    {
        int l = 0, r = elementos.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (elementos[m] == x)
                return m;

            if (elementos[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }
        return -1;
    }
}
