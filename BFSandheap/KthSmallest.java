package BFSandheap;

import java.util.*;

public class KthSmallest {
    //tc: O(nlogk)
    //sc: O(k)
    public int[] kSmallest(int[] array, int k) {
        int[] result = new int[k];
        if (array.length == 0 || k == 0) return result;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else {
                if (array[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
