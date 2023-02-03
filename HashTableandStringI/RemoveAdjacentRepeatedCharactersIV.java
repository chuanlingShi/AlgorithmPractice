package HashTableandStringI;

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        if (input == null || input.isEmpty()) return input;
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }else {
                slow--;
                while (fast + 1 < array.length && array[fast] == array[fast+1]) {
                    fast++;
                }
            }
        }
        return new String(array, 0, slow+1);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersIV charactersIV = new RemoveAdjacentRepeatedCharactersIV();
        String result = charactersIV.deDup("eabcdddcbba");
    }
}
