package SwordToOffer.middle;


import java.util.ArrayList;
import java.util.List;

public class Offer_34 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root != null) dfs(root, target, 0, path);
        return result;
    }

    private void dfs(TreeNode root, int target, int sum, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            if (sum + root.val == target && root.left == null && root.right == null) {
                result.add(new ArrayList<>(path));
            }
            dfs(root.left, target, sum + root.val, path);
            dfs(root.right, target, sum + root.val, path);
            path.remove(path.size() - 1);
        }
    }
}
