package BTandBST;

import utility.TreeNode;

public class DeleteInBST {
    //tc: O(height)
    //sc: O(height)
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.key) {
            root.left = deleteTree(root.left, key);
            return root;
        }else if (key > root.key) {
            root.right = deleteTree(root.right, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }else if (root.right == null) {
            return root.left;
        }
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }else {
            TreeNode minNode = getMin(root.right);
            minNode.left = root.left;
            minNode.right = root.right;
            return minNode;
        }
    }

    private TreeNode getMin(TreeNode root) {
        TreeNode prev = root;
        while (root.left != null) {
            prev = root;
            root = root.left;
        }
        prev.left = root.right;
        return root;
    }
}
