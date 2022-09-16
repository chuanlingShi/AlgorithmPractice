package DP;

/**
 * Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
 *
 * Assumptions
 *
 * Both strings are not null
 * Examples
 *
 * string one: “sigh”, string two : “asith”
 *
 * the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 */
//TC:O(m*n), SC:O(m*n)
public class EditDistance {
    public int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = one.length(); i >= 0; i--) {
            for (int j = two.length(); j >= 0; j--) {
                if (i == one.length()) {
                    distance[i][j] = two.length() - j;
                }else if (j == two.length()) {
                    distance[i][j] = one.length() - i;
                }else if (one.charAt(i) == two.charAt(j)) {
                    distance[i][j] = distance[i + 1][j + 1];
                }else {
                    distance[i][j] =Math.min(distance[i + 1][j] + 1, distance[i][j + 1] + 1);
                    distance[i][j] =Math.min(distance[i + 1][j + 1] + 1, distance[i][j]);
                }
            }
        }
        return distance[0][0];
    }
}
