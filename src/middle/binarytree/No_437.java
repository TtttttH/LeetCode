package middle.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * No.437 路径总和III (微软)
 */
public class No_437 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return count;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(root, preSum, 0, targetSum);
        return count;
    }

    private void helper(TreeNode root, Map<Integer, Integer> preSum, int curSum, int target) {
        if (root == null) return;
        curSum += root.val;
        count += preSum.getOrDefault(target - curSum, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        helper(root.left, preSum, curSum, target);
        helper(root.right, preSum, curSum, target);
        preSum.put(curSum, preSum.get(curSum) - 1); //注意这里需要回溯，防止上层节点遍历的时候出现下层其他子节点的前缀和
    }
}
