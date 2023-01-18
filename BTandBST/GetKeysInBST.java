package BTandBST;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBST {
    //tc: O(n)
    //sc: O(height)
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();
        getRange(result, root, min, max);
        return result;
    }

    private void getRange(List<Integer> result, TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.key > min) {
            getRange(result,root.left, min, max);
        }
        if (root.key <= max && root.key >= min) {
            result.add(root.key);
        }
        if (root.key < max) {
            getRange(result, root.right, min, max);
        }
    }
}
