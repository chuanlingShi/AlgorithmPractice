package BTandBST;
import utility.TreeNode;

public class IsBalanced {
    //tc: O(nlogn)
    //sc: O(logn)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if (left && right) {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
        return false;
    }

    private int getHeight(TreeNode root) {
         if (root == null) return 0;
         int left = getHeight(root.left);
         int right = getHeight(root.right);
         return Math.max(left, right) + 1;
    }

}
