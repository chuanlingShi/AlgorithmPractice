package HashTableandStringI;

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.isEmpty()) return input;
        char[] array = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow-1] != array[fast]) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }
}
