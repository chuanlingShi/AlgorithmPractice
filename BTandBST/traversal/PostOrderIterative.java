package BTandBST.traversal;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderIterative {
    //sc: O(n)
    //tc: O(height)
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (pre == null || cur == pre.left || cur == pre.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                }else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    result.add(stack.pollFirst().key);
                }
            }else if (pre == cur.left) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    result.add(stack.pollFirst().key);
                }
            } else if (pre == cur.right){
                result.add(stack.pollFirst().key);
            }
            pre = cur;
        }
        return result;
    }
}
