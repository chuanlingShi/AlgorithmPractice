package BFSandheap;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayerByLayer {
    //tc: O(n)
    //sc: O(n)
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLayer = new ArrayList<>();
            for (int i = 0 ; i< size; i++) {
                TreeNode cur = queue.poll();
                currentLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(currentLayer);
        }
        return result;
    }
}
