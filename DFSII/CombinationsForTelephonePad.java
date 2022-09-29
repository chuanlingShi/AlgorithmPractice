package DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers,
 * the output strings should be sorted.
 *
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
 *
 * Assumptions:
 *
 * The given number >= 0
 * Examples:
 *
 * if input number is 231, possible words which can be formed are:
 *
 * [ad, ae, af, bd, be, bf, cd, ce, cf]
 */
public class CombinationsForTelephonePad {
    public String[] combinations(int number) {
        List<String> result = new ArrayList<>();
        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(Integer.toString(number).toCharArray(), numToChar, 0, sb, result);
        return result.toArray(new String[0]);
    }

    private void helper(char[] number, String[] numToChar, int level, StringBuilder sb, List<String> result) {
        if (level == number.length) {
            result.add(sb.toString());
            return;
        }
        char[] chars = numToChar[number[level] - '0'].toCharArray();
        if (chars.length == 0) {
            helper(number, numToChar, level + 1, sb, result);
        } else {
            for (int i = 0; i < chars.length; ++i) {
                helper(number, numToChar, level + 1, sb.append(chars[i]), result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
