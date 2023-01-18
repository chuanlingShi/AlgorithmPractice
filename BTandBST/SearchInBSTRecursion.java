package BTandBST;

import utility.TreeNode;

public class SearchInBSTRecursion {
    //tc: O(n)
    //sc: O(height)
    public TreeNode search(TreeNode root, int key) {
        if (root == null) return null;
        if (key == root.key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }else {
            return search(root.right, key);
        }
    }
}
