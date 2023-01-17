package Tree.LCA;

import utility.TreeNode;

/**
 * Given two keys in a binary search tree, find their lowest common ancestor.
 *
 * Assumptions
 *
 * There is no parent pointer for the nodes in the binary search tree
 *
 * There are no duplicate keys in the binary search tree
 *
 * The given two nodes are guaranteed to be in the binary search tree
 *
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      2     12
 *
 *    /  \      \
 *
 *   1    3      14
 *
 * The lowest common ancestor of 1 and 14 is 5
 *
 * The lowest common ancestor of 1 and 3 is 2
 */
//TC: O(height) SC: O(1)
public class LowestCommonAncestor {
    public TreeNode lca(TreeNode root, int p, int q) {
        int small = Math.min(p, q);
        int large = Math.max(p, q);
        while (root != null) {
            if (root.key < small) {
                root = root.right;
            }else if (root.key > large) {
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }
}
