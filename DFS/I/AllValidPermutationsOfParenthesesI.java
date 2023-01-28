package DFS.I;

import java.util.ArrayList;
import java.util.List;


public class AllValidPermutationsOfParenthesesI {
    //tc: O(2^(2n) * (2n))
    //sc: O(2n) -> O(n)
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        validParentheses(stringBuilder, n, n, result);
        return result;
    }

    private void validParentheses(StringBuilder stringBuilder, int leftRemain, int rightRemain, List<String> result) {
        if (leftRemain == 0 && rightRemain == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        //add left
        if (leftRemain > 0) {
            stringBuilder.append("(");
            validParentheses(stringBuilder, leftRemain - 1, rightRemain, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        //add right
        if (rightRemain > leftRemain) {
            stringBuilder.append(")");
            validParentheses(stringBuilder, leftRemain, rightRemain - 1, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllValidPermutationsOfParenthesesI a = new AllValidPermutationsOfParenthesesI();
        a.validParentheses(2);
    }
}
