import java.util.Arrays;

public class Driver {
    public static void main (String[] argv){
        int[] array = {2,9,1,3,5,6,10};

//        SelectionSort solution = new SelectionSort();
//        solution.selectSort(array);
//        System.out.println("After:" + Arrays.toString(array));

//        MergeSort solution = new MergeSort();
//        System.out.println("After:" + Arrays.toString(solution.mergeSort(array)));

        QuickSort solution = new QuickSort();
        solution.quickSort(array);
        System.out.println("After:" + Arrays.toString(array));

    }
}
