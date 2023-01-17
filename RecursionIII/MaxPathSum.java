package RecursionIII;

import utility.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number.
 * Find the maximum possible path sum from a leaf to root.
 *
 *
 * Assumptions
 *
 * The root of given binary tree is not null.
 *
 *
 *
 * Examples
 *
 *
 *
 *          10
 *
 *        /      \
 *
 *     -2        7
 *
 *   /     \
 *
 * 8      -4
 *
 * The maximum path sum is 10 + 7 = 17.
 */
public class MaxPathSum {
    public int maxPathSumLeafToRoot(TreeNode root) {
        return maxPathSum(root, 0);

    }

    private int maxPathSum(TreeNode root, int sum) {
        sum += root.key;
        if (root.left == null && root.right == null) {
            return sum;
        }else if (root.left == null) {
            return maxPathSum(root.right, sum);
        }else if (root.right == null) {
            return maxPathSum(root.left, sum);
        }
        return Math.max(maxPathSum(root.left,sum), maxPathSum(root.right,sum));
    }
}
