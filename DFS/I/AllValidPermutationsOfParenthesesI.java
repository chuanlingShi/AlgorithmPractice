package DFS.I;

import java.util.ArrayList;
import java.util.List;


public class AllValidPermutationsOfParenthesesI {
    //tc: O(2^(2n))
    //sc: O(2n)
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
        }
        //add right
        if (rightRemain > leftRemain) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            validParentheses(stringBuilder, leftRemain, rightRemain - 1, result);
        }
    }
}
