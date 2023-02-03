package StringII;

public class StringReplace {
    public String replace(String input, String source, String target) {
        if(target.isEmpty()) return source;
        //find the space to extend
        char[] chars = input.toCharArray();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        int dif = target.length() - source.length();
        int spaceToAdd = 0;
        if (dif > 0) {
            spaceToAdd = count(chars, sourceArray) * dif;
            chars = expand(chars, spaceToAdd);
        }
        int i = chars.length - 1;
        int j = i - spaceToAdd;
        while (j >= 0) {
            //replace if match the source
            if (j >= sourceArray.length - 1 && isMatchReverse(chars, j, sourceArray)) {
                for (int k = targetArray.length - 1; k >= 0; k--) {
                    chars[i--] = targetArray[k];
                }
                j -= sourceArray.length;
            }else {
                chars[i--] = chars[j--];
            }
        }
        return new String(chars, i-1, chars.length - (i-1));

    }

    private boolean isMatchReverse(char[] chars, int i, char[] source) {
        for (int j = source.length - 1; j >= 0; j--) {
            if (source[j] != chars[i]) {
                return false;
            }
            i--;
        }
        return true;
    }

    private char[] expand(char[] chars, int space) {
        char[] array = new char[chars.length + space];
        for (int i = 0; i < chars.length; i++) {
            array[i] = chars[i];
        }
        return array;
    }

    private int count(char[] chars, char[] source) {
        int count = 0;
        int j = 0;
        for (int i = 0; i <= chars.length - source.length; i++) {
            if (isMatch(chars, i, source)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatch(char[] chars, int i, char[] source) {
        for (char c : source) {
            if (chars[i] != c) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        StringReplace stringReplace = new StringReplace();
        String result = stringReplace.replace("tywjtltyvtyegcboycmqtyq","ty","c");
    }
}
