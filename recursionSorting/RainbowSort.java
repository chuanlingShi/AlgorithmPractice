package recursionSorting;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        if (array.length <= 1) return array;
        //[0, i) : -1
        //[i, j) : 0
        //[j, k] : unknown
        //(k, right] : 1
        int i = 0;
        int j = 0;
        int k = array.length;
        while (j <= k ) {
            if (array[j] == -1) {
                swap(array, i, j);
                i++;
                j++;
            }else if (array[j] == 0) {
                j++;
            }else {
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
