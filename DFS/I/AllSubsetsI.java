package DFS.I;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    //tc: O(2^n * n)
    //sc: O(n)
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) return result;
        StringBuilder stringBuilder = new StringBuilder();
        char[] array = set.toCharArray();
        subSets(array, 0, stringBuilder, result);
        return result;
    }

    private void subSets(char[] array, int index, StringBuilder stringBuilder, List<String> result) {
        //index: current considering character
        //base case
        if (index == array.length) {
            result.add(stringBuilder.toString());
            return;
        }
        //add
        stringBuilder.append(array[index]);
        subSets(array,index + 1, stringBuilder, result);

        //not add
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        subSets(array, index + 1, stringBuilder, result);
    }
}
