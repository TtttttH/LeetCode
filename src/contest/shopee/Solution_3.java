package contest.shopee;

import java.util.*;

public class Solution_3 {
    public int getNumber(TreeNode root, int[][] ops) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            map.put(cur.val, 0);
            cur = cur.right;
        }


        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 0) res ++;
        }
        return res;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
