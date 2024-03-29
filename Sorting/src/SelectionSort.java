public class SelectionSort {
    public void selectSort(int[] array){
        //corner case
        if (array == null || array.length <= 1){
            return;
        }
        for(int i = 0; i < array.length -1; i++){
            int minIndex = i;
            for(int j = i + 1; j< array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
