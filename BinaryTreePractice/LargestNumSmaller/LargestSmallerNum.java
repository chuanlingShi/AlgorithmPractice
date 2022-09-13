package BinaryTreePractice.LargestNumSmaller;

import test.TreeNode;

public class LargestSmallerNum {
    public int largestSmaller (TreeNode root, int target) {
        int largestSmallerSoFar = Integer.MIN_VALUE;
        while (root != null) {
            if(root.key >= target) {
                root = root.left;
            } else {
                largestSmallerSoFar = root.key;
                root= root.right;
            }
        }
        return largestSmallerSoFar;
    }
}
