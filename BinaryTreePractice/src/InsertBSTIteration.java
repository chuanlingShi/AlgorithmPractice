public class InsertBSTIteration {
    public TreeNode insert(TreeNode root, int target){
        if(root == null){
            return new TreeNode(target);
        }

        TreeNode cur = root;
        while(target != cur.key){
            if(target < cur.key){
                if(cur.left == null){
                    cur.left = new TreeNode(target);
                    break;
                }
                else {
                    cur = cur.left;
                }
            }
            else {
                if(cur.right == null){
                    cur.right = new TreeNode(target);
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
        }
        return root;
    }

}
