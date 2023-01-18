package BTandBST.traversal;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderIterative {
    //tc: O(n)
    //sc: O(height)
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode nextNode = root;
        while (!stack.isEmpty() || nextNode != null) {
            if (nextNode != null) {
                stack.offerFirst(nextNode);
                nextNode = nextNode.left;
            } else {
                nextNode = stack.pollFirst();
                result.add(nextNode.key);
                nextNode = nextNode.right;
            }
        }
        return result;
    }
}
