package StringII;

public class ReverseSentence {
    //tc: O(n)
    //sc: O(1)
    public String reverseWords(String input) {
        if (input.isEmpty()) return input;
        char[] chars = input.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int i = 0;
        for (int j = 1; j < input.length(); j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }else if (j == input.length() - 1) {
                reverse(chars, i, j);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
