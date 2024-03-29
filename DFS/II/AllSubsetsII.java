package DFS.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.
 *
 * Assumptions
 *
 * There could be duplicate characters in the original set.
 * ​Examples
 *
 * Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
 * Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */
public class AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        helper(set, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index ++;
        }
        helper(set, sb, index + 1, result);
    }
}
