package HashTableandStringI;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        if (input.isEmpty()) return input;
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != ' ' || (slow != 0 && array[slow-1] != ' ')) {
                array[slow++] = array[fast];
            }
        }
        //post-processing
        if (slow > 0 && array[slow-1] == ' ') {
            return new String(array, 0, slow - 1);
        }
        return new String(array,0, slow);
    }
}
