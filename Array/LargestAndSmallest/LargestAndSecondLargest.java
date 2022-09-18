package Array.LargestAndSmallest;

import java.util.ArrayList;
import java.util.List;

//O(n), O(n)
public class LargestAndSecondLargest {
    static class Element {
        int value;
        List<Integer> comparedValues;

        Element(int value) {
            this.value = value;
            this.comparedValues = new ArrayList<>();
        }
    }
    public int[] largestAndSecond(int[] array) {
        Element[] helper = convert(array);
        int largerLength = array.length;
        while (largerLength > 1) {
            comparedAndSwap(helper, largerLength);
            largerLength = (largerLength + 1) / 2;
        }
        return new int[] {helper[0].value, largest(helper[0].comparedValues)};
    }

    private Element[] convert(int[] array) {
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++){
            helper[i] = new Element(array[i]);
        }
        return helper;
    }

    private void comparedAndSwap(Element[] helper, int largerLength) {
        for (int i = 0; i < largerLength / 2; i++){
            if (helper[i].value < helper[largerLength - 1- i].value) {
                swap(helper, i, largerLength -1 -i);
            }
            helper[i].comparedValues.add(helper[largerLength - 1 -i].value);
        }
    }

    private void swap(Element[] helper, int left, int right) {
        Element tmp = helper[left];
        helper[left] = helper[right];
        helper[right] = tmp;
    }

    private int largest(List<Integer> list) {
        int max = list.get(0);
        for (int n : list) {
            max = Math.max(max, n);
        }
        return max;
    }
}
