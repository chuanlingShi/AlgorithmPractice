package DFS.II;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.
 *
 * Assumptions
 *
 * There are no duplicate characters in the original set.
 *
 * ​Examples
 *
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 *
 * Set = "", K = 0, all the subsets are [""].
 *
 * Set = "", K = 1, all the subsets are [].
 */
public class AllSubsetsofSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null ) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, k, sb, 0, result);
        return result;
    }

    private void helper(char[] set, int k, StringBuilder sb, int index, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == set.length) {
            return;
        }
        helper(set, k, sb,index+1, result);
        helper(set, k, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
