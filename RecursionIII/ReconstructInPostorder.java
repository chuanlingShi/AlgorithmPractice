package RecursionIII;

import utility.TreeNode;

/**
 * Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequence is not null
 * There are no duplicate keys in the binary search tree
 * Examples
 *
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 *
 * the corresponding binary search tree is
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * How is the binary tree represented?
 *
 * We use the pre order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 */
public class ReconstructInPostorder {
    public TreeNode reconstruct(int[] post) {
        int[] index = new int[] {post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] postorder, int[] index, int min) {
        if (index[0] < 0 || postorder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index[0]--]);
        root.right = helper(postorder, index, root.key);
        root.left = helper(postorder, index, min);
        return root;
    }
}
