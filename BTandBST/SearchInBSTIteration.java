package BTandBST;

import utility.TreeNode;

public class SearchInBSTIteration {
    //tc: O(n)
    //sc: O(1)
    public TreeNode search(TreeNode root, int key) {
        while (root != null) {
            if (root.key == key) {
                return root;
            }else if (key < root.key) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return null;
    }
}
