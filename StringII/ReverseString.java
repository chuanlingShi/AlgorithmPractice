package StringII;

public class ReverseString {
    public String reverse(String input) {
        char[] array = input.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
        return new String(array);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
