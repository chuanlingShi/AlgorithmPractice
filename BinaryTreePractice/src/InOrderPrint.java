public class InOrderPrint {
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }
}
