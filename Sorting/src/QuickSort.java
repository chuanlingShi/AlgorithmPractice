import java.util.Random;

public class QuickSort {
    //why not declare rand in the method? save heap memory
    private Random rand = new Random();
    public void quickSort(int[] array){
        //corner case:
        if(array == null || array.length == 1){
            return;
        }
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(int[] array, int left, int right){
        //base case: left >= right
        if(left >= right){
            return;
        }
        //prepossessing:
        //step1: randomly choose a pivot between left and right, both included
        int pivot = left + rand.nextInt(right - left + 1);
        swap(array, pivot, right);

        //step2: partition
        int i = left;
        int j = right - 1;
        while (i <= j){
            if(array[i] >= array[right]){
                swap(array, i, j);
                j--;
            }
            else {
                i++;
            }
        }
        //step3: put pivot back
        swap(array, i, right);
        //sub-problem: quickSort 蓝队(>= pivot), quick sort 红队(< pivot)
        quickSort(array, left, i -1);
        quickSort(array, i + 1, right);
        //recursion rule: same as sub-problem

    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        long num1 = (long)((long)10 + 5.0);
        char c = 'a';
    }

}
