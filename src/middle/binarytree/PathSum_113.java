package middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.113 路径总和II
 */
public class PathSum_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        List<Integer> paths = new ArrayList<>();
        traversal(root, targetSum, results, paths);
        return results;
    }

    private void traversal (TreeNode node, int targetSum, List<List<Integer>> results, List<Integer> paths) {
        paths.add(node.val);
        if (node.left == null && node.right == null && targetSum - node.val == 0) {
            results.add(new ArrayList<>(paths));
        }

        if (node.left != null) {
            traversal(node.left, targetSum - node.val, results, paths);
            paths.remove(paths.size() - 1);
        }

        if (node.right != null) {
            traversal(node.right, targetSum - node.val, results, paths);
            paths.remove(paths.size() - 1);
        }
    }

}
