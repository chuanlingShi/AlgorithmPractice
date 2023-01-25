package heap;

import java.util.*;

public class KthSmallest {
    public List<Integer> smallest(List<Integer> array, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(array);
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        return result;
    }
}
