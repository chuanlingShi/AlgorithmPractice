package Array.Move0s;

public class Move0sToTheEndII {
    public int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[end ++] = array[i];
            }
        }
        for (int i = end; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }
}
