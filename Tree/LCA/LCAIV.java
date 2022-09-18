package Tree.LCA;

import test.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCAIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right, set);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }
}
