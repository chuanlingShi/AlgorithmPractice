package DFS.II;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.
 *
 *
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].
 *
 * Set = “”, all permutations are [“”].
 *
 * Set = null, all permutations are [].
 */
public class AllPermutationsofSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result) {
        result.add(new String(array, 0, index));
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
