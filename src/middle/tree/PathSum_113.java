package middle.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.113 路径总和
 */
public class PathSum_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        List<Integer> path = new ArrayList<>();

        traversel(root, targetSum, results, path);

        return results;
    }

    private void traversel(TreeNode node, int targetSum, List<List<Integer>> results, List<Integer> path) {
        path.add(node.val);
        targetSum = targetSum - node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            traversel(node.left, targetSum, results, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            traversel(node.right, targetSum, results, path);
            path.remove(path.size() - 1);
        }
    }
}
