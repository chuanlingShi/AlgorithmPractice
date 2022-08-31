
public class Height {
    public int getHeight(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

//sub
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

//recursion rule
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
