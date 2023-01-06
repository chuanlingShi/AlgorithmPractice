package recursionSorting;

import java.util.Random;

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) return array;
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }
        //sub problem
        //recursive rule
        int pivot = partition(array, left, right);
        //partition
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);

    }

    private int partition(int[] array, int left, int right) {
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        swap(array, pivot, right);
        int i = left;
        int j = right - 1;
        //(left, i) : smaller than pivot
        //[i, j] : unknown area
        //(j, right] : greater than pivot

        while(i <= j) {
            if (array[i] >= array[right]) {
                swap(array, i, j);
                j--;
            }else {
                i++;
            }
        }
        swap(array, right, i);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
