package HashTableandStringI;

public class Substring {
    //tc: O((m-n) * n)
    //sc: O(1)
    public int strstr(String large, String small) {
        if (large.length() < small.length()) return -1;
        if (small.length() == 0) return 0;
        char[] largeArray = large.toCharArray();
        char[] smallArray = small.toCharArray();
        for (int i = 0; i <= largeArray.length - smallArray.length; i++) {
            if (isMatch(largeArray, smallArray, i)) {
                return i;
            }
        }
        return -1;
    }

    boolean isMatch(char[] string, char[] pattern, int i) {
        for (char c : pattern) {
            if (string[i] != c) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
