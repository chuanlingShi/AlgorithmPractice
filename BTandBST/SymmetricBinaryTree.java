package BTandBST;
import utility.TreeNode;

public class SymmetricBinaryTree {
    //tc: O(n)
    //sc: O(height)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        //case1: both null -> true
        //case2: one null -> false
        //case3: both not null, check key
        if (left == null && right == null) return true;
        if (left == null || right == null) {
            return false;
        }
        if (left.key != right.key ){
            return false;
        }

        return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);

    }
}
