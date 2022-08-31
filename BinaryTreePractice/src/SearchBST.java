public class SearchBST {
    public TreeNode searchBST(TreeNode root, int target){
        //basecase
        if(root == null || target == root.key) return root;

        //recursion rule
        if (target < root.key){
            return searchBST(root.left, target);
        }
        else{
            return searchBST(root.right, target);
        }
    }

}
