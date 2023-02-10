package DPI;

public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int globalMax = 1;
        int prevLength = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] < array[i]) {
               globalMax = Math.max(globalMax, ++prevLength);
            }else {
                prevLength = 1;
            }
        }
        return globalMax;
    }
}
