package DP;

/***
 * Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
 *
 * For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”.
 *
 * Determine the fewest cuts needed for palindrome partitioning of a given string.
 *
 * For example,
 *
 * minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
 *
 * If a string is palindrome, then minimum 0 cuts are needed.
 *
 * Return the minimum cuts.
 */
public class MinCutPalindrome {
    public int minCut (String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }
        char[] array = input.toCharArray();
        int n = array.length;
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i < M.length; i++){
            int minCutForI = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {//j is Left Big Section
                if (isPalindrome(array, j, i - 1)) {
                    minCutForI = 0;
                    break;
                } else {
                    minCutForI = Math.min(minCutForI, M[j] + 1);
                }
            }
            M[i] = minCutForI;
        }
        return M[n];
    }

    private boolean isPalindrome(char[] array, int i, int j){
        while (i < j){
            if(array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
