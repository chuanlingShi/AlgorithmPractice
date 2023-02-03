package StringII;

public class RightShift {
    //tc: O(m), m is the length of the input string
    //sc: O(1)
    public String rightShift(String input, int n) {
        if (input.isEmpty()) return input;
        char[] chars = input.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, n % chars.length - 1);
        reverse(chars, n % chars.length, chars.length - 1);
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
