package recursionII;

import utility.TreeNodeLeft;

public class NodesInLeftSubtree {
    //tc: O(n)
    //sc: O(height)
    public void numNodesLeft(TreeNodeLeft root) {
        recursion(root);
    }

    private int recursion(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        root.numNodesLeft = recursion(root.left);
        return root.numNodesLeft + recursion(root.right) + 1;
    }
}
