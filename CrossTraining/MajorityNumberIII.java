package CrossTraining;

import java.util.*;

public class MajorityNumberIII {
    public List<Integer> majority(int[] array, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : array) {
            map.put(i, 0);
        }
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > array.length / k) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


    public static void main(String[] argv) {
        MajorityNumberIII majorityNumberIII = new MajorityNumberIII();
        List<Integer> list = majorityNumberIII.majority(new int[]{1,2}, 3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
