public class BalancedTree {
    public boolean isBalanced(TreeNode root){
        if(root == null)return true;
        return getHeight(root) != -1;
    }


    //return -1 if not balanced
    private int getHeight(TreeNode root){
        //base case
        if(root == null) return 0;

        //subproblem

        int leftHeight = getHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = getHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }

        //recursion rule
        if (Math.abs(leftHeight - rightHeight ) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
