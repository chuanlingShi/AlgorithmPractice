package BFSandheap;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsCompletedBT {
    //tc: O(n)
    //sc: O(height)
    public boolean isCompleted(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (hasNull) return false;
                queue.offer(cur.left);
            }else if (!hasNull) hasNull = true;

            if (cur.right != null) {
                if (hasNull) return false;
                queue.offer(cur.right);
            }else if (!hasNull) hasNull = true;
        }
        return true;
    }
}
