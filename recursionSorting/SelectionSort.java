package recursionSorting;

public class SelectionSort {
    //TC: O(n^2) , SC: O(1)
    public int[] solve(int[] array) {
        if (array == null) return null;
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
