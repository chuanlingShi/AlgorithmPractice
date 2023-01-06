package recursionSorting;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int left, int right) {
        //base case
        if (left == right) {
            return new int[]{array[left]};
        }
        //sub problem
        //recursive rule
        int mid = left - (left - right) / 2;
        int[] leftArray = mergeSort(array, left, mid);
        int[] rightArray = mergeSort(array, mid + 1, right);
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                result[k] = leftArray[i];
                i++;
            }else {
                result[k] = rightArray[j];
                j++;
            }
            k++;
        }
        //append left remains to result if left array not empty, vice versa
        while (i < leftArray.length) {
            result[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            result[k] = rightArray[j];
            j++;
            k++;
        }
        return result;
    }
}
