package GraphSearchIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s0, String s1) {
                if (s0.length() == s1.length()) {
                    return 0;
                }
                return s0.length() < s1.length() ? 1 : -1;
            }
        });
        int largest = 0;
        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                int prod = dict[i].length() * dict[j].length();
                if (prod <= largest) {
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    largest = prod;
                }
            }
        }
        return largest;
    }

    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : dict) {
            int bitMask = 0;
            for (int i = 0; i < s.length(); i++) {
                bitMask |= 1 << (s.charAt(i) - 'a');
            }
            map.put(s, bitMask);
        }
        return map;
    }
}
