package GraphSearchIII;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class thSmallestWithOnlyFactors {
    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Set<Long> visited = new HashSet<>();
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (k > 1) {
            long cur = minHeap.poll();
            if (visited.add(3 * cur)) {
                minHeap.offer(3 * cur);
            }
            if (visited.add(5 * cur)) {
                minHeap.offer(5 * cur);
            }
            if (visited.add(7 * cur)) {
                minHeap.offer(7 * cur);
            }
            k--;
        }
        return minHeap.peek();
    }
}
