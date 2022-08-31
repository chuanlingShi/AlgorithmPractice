public class DeleteBST {
    public TreeNode delete(TreeNode root, int target){
        if(root == null){
            return root;
        }
        //search for the target
        if(target < root.key){
            root.left = delete(root.left, target);
        }
        else if (target > root.key){
            root.right = delete(root.right, target);
        }else{ //root != null && target == root.key
            //at most one subtree
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            //root has both subtrees
            else {
                //root.right is the min
                if(root.right.left == null){
                    root.right.left = root.left;
                    return root.right;
                }
                else{//root.right.left != null
                    //find and delete the min node
                    TreeNode min = deleteMin(root.right);
                    min.left = root.left;
                    min.right = root.right;
                    return min;
                }
            }
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode cur){
        //find the most left node
        TreeNode pre = cur;
        cur = cur.left;
        while(cur.left != null){
            pre = cur;
            cur = cur.left;
        }
        //delete the node
        pre.left = cur.right;
        return cur;
    }

}
