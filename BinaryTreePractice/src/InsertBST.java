public class InsertBST {
    public TreeNode insert(TreeNode root, int target){
        if(root == null){
            return new TreeNode(target);
        }

        if(target == root.key){
            return root;
        }
        else if(target < root.key){
            root.left = insert(root.left, target);
        }
        else {
            root.right = insert(root.right, target);
        }

        return root;
    }

}
