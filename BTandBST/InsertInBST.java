package BTandBST;

import utility.TreeNode;

public class InsertInBST {
    //tc: O(n)
    //sc: O(height)
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
