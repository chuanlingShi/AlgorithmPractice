package HashTableandStringI;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbers {
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        if (A.length == 0 || B.length == 0) return result;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length){
            if (A[i] == B[j]) {
                result.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            }else {
                j++;
            }
        }
        return result;
    }
}
