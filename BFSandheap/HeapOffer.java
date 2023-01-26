package BFSandheap;

public class HeapOffer {
    public int[] offerHeap(int[] array, int ele) {
        int index = array.length - 1;
        array[index] = ele;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array,parentIndex, index);
                index = parentIndex;
            }else {
                break;
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
