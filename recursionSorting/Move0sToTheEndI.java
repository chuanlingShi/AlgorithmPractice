package recursionSorting;

public class Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array.length <= 1) return array;
        //[0, i) : non-zero
        //[i, j] : unknown
        //(j, rightBound] : 0
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] == 0) {
                swap(array, i, j);
                j--;
            }else {
                i++;
            }
        }
        return array;
    }

    private void  swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
