package HashTableandStringI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    //tc: O(n + nlogk)
    //sc: O(n)
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) return new String[0];
        //hashmap count
        Map<String, Integer> map = new HashMap<>();
        for (String word : combo) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 0);
            }else {
                map.put(word, count + 1);
            }
        }
        //get top k from min heap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> {
            return o1.getValue().compareTo(o2.getValue());
        });
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] result = new String[minHeap.size()];
        //reverse the order in min heap
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
