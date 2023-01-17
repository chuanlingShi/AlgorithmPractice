package BTandBST.traversal;
import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderRecursive {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.key);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
