package StringII;

public class CompressString {
    public String compress(String input) {
        if (input.isEmpty()) return input;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                count = 1;
                stringBuilder.append(chars[i]);
            }else if (chars[i] == chars[i-1]) {
                count++;

            }else {
                stringBuilder.append(count);
                count = 1;
                stringBuilder.append(chars[i]);

            }
            if (i == chars.length - 1) {
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }
}
