package BTandBST;

import utility.TreeNode;

public class InsertInBSTIteration {
    //tc: O(n)
    //sc: O(1)
    public TreeNode insert(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) return newNode;
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            prev = cur;
            if (key == cur.key) {
                return root;
            }else if (key < cur.key) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        if (key < prev.key) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
        return root;
    }
}
