package HashTableandStringI;

public class MissingNumberI {
    public int missing(int[] array) {
        if (array.length == 0) return 1;
        int n = array.length + 1;
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }
}
