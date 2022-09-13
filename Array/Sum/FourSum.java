package Array.Sum;


import java.util.Arrays;

public class FourSum {
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i ++) {
            for (int j = i + 1; j < array.length - 2; j ++) {
                int left = j + 1;
                int right = array.length - 1;
                int curTarget = target - array[i] - array[j];
                while (left < right) {
                    int sum = array[left] + array[right];
                    if(sum == curTarget) {
                        return true;
                    }else if (sum < curTarget) {
                        left ++;
                    }else {
                        right --;
                    }
                }
            }
        }
        return false;
    }

    static class Element implements Comparable<Element> {
        int left;
        int right;
        int sum;

        Element(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        @Override
        public int compareTo(Element another) {
            if(this.sum != another.sum) {
                return this.sum < another.sum ? -1 : 1;
            }else if (this.right != another.right) {
                return this.left < another.left ? -1 : 1;
            }
            return 0;
        }
    }
}
