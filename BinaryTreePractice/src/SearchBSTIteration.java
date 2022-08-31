public class SearchBSTIteration {
    public TreeNode searchI(TreeNode root, int target){
        if(root == null){
            return root;
        }
        TreeNode cur = root;
        while(cur != null){
            if(target == cur.key){
                return cur;
            }
            else if (target < cur.key){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return null;
    }

}
