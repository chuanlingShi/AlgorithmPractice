package HashTableandStringI;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    //tc: O(m + n)
    //sc: O(m + n)
    public String remove(String input, String t) {
        if (t.length() == 0 || input.length() == 0) return input;
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            set.add(c);
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (!set.contains(array[fast])) {
                array[slow] = array[fast];
                slow++;
            }
            fast++;
        }
        return new String(array, 0, slow);
    }
}
