package Recursion.Tree.LCA;
import test.TreeNode;
/**
 * Given two nodes in a binary tree, find their lowest common ancestor.
 *
 * Assumptions
 *
 * There is no parent pointer for the nodes in the binary tree
 *
 * The given two nodes are guaranteed to be in the binary tree
 *
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      9     12
 *
 *    /  \      \
 *
 *   2    3      14
 *
 * The lowest common ancestor of 2 and 14 is 5
 *
 * The lowest common ancestor of 2 and 9 is 9
 */

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode one, TreeNode two) {
        if(root == null) {
            return null;
        }
        if(root == one || root == two) {
            return root;
        }

        TreeNode ll = lowestCommonAncestor(root.left, one, two);
        TreeNode lr = lowestCommonAncestor(root.right, one, two);

        if(ll != null && lr != null) {
            return root;
        }
        return ll == null ? lr : ll;
    }
}
