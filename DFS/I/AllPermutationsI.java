package DFS.I;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    //tc: O(n!)
    //sc: O(n), n is the length of input string
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        permutations(chars, 0, result);
        return result;
    }

    private void permutations(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutations(chars, index + 1, result);
            //swap back
            swap(chars, index, i);
        }

    }

    private void swap(char[] array, int l, int r) {
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
