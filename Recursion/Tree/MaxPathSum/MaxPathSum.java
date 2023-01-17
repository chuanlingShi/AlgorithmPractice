package Recursion.Tree.MaxPathSum;
import utility.TreeNode;
/***
 * Given a binary tree in which each node contains an int number.
 *
 * Find the maximum possible sum from any leaf node to another leaf node.
 *
 * The maximum sum path may or may not go through root.
 *
 * Expected time complexity is O(n).
 */

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxGain(root, maxSum);
        return maxSum[0];
    }

    private int maxGain(TreeNode node, int[] maxSum) {
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null) {
            return node.key;
        }

        int leftGain = maxGain(node.left, maxSum);
        int rightGain = maxGain(node.right, maxSum);

        if(node.left != null && node.right != null) {
            int newPathGain = node.key + leftGain + rightGain;
            maxSum[0] = Math.max(maxSum[0], newPathGain);
            return node.key + Math.max(leftGain, rightGain);
        }

        return node.left == null ? rightGain + node.key : leftGain + node.key;
    }
}
