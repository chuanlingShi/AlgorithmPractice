package String;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
 *
 * Assumptions
 *
 * The string is not null
 *
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 *
 * Examples
 *
 * “abbcccdeee” → “a1b2c3d1e3”
 */
public class CompressStringII {

    public String compress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] input) {
        int slow = 0;
        int fast = 0;
        int newLength = 0;

        while(fast < input.length){
         int begin = fast;
         while (fast < input.length && input[fast] == input[begin]) {
             fast ++;
         }
         input[slow++] = input[begin];
         if (fast - begin == 1) {
             newLength += 2;
         }else {
             int len = copyDigits(input, slow, fast - begin);
             slow += len;
             newLength += len + 1;
         }
        }

        char[] result = new char[newLength];
        fast = slow - 1;
        slow = newLength - 1;
        while (fast >= 0) {
            if (Character.isDigit(input[fast])) {
                while (fast >= 0 && Character.isDigit(input[fast])) {
                    result[slow--] = input[fast--];
                }
            }else {
                result[slow--] = '1';
            }
            result[slow--] = input[fast--];
        }
        return new String(result);
    }

    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for (int i = count; i >0; i /= 10){
            index ++;
            len ++;
        }
        for (int i = count; i >0; i /= 10) {
            int digit = i % 10;
            input[--index] = (char) ('0' + digit);
        }
        return len;
    }
}
