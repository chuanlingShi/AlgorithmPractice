package BinaryTreePractice.ClosestNumberBST;

import test.TreeNode;

public class ClosestNumber {
    public int closest(TreeNode root, int target) {
        int currentClosest = root.key;
        while(root != null) {
            if(root.key == target) {
                return root.key;
            }else {
                if(Math.abs(root.key - target) < Math.abs(currentClosest - target)) {
                    currentClosest = root.key;
                }
                if(root.key < target) {
                    root = root.right;
                }else {
                    root = root.left;
                }
            }
        }
        return currentClosest;
    }
}
