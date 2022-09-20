package DFS.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.
 *
 *
 *
 * Assumptions
 *
 * There could be duplicate characters in the original set.
 *
 * ​
 *
 * Examples
 *
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 *
 * Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
 *
 * Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
 *
 * Set = "", K = 0, all the subsets are [""].
 *
 * Set = "", K = 1, all the subsets are [].
 *
 * Set = null, K = 0, all the subsets are [].
 */
public class AllSubsetsIIofK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, k, sb, 0, res);
        return res;
    }

    private void helper(char[] set, int k, StringBuilder sb, int index, List<String> res) {
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (index == set.length) {
            return;
        }
        helper(set, k, sb.append(set[index]), index + 1, res);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index ++;
        }
        helper(set, k, sb, index + 1, res);
    }
}
