package Array.dedup;


import java.util.Arrays;

//TC: O(n) SC: O(1)
public class ArrayDeduplicationI {
    public static int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[end]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

    public static void main(String[] argv) {
        int[] array = {1, 2, 2, 3, 3, 4, 5};
        dedup(array);
    }
}
