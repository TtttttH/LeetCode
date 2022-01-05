package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.515 在每个树行中找最大值
 */
public class LargestValues_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return results;
        }

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            results.add(max);
        }
        return results;
    }
}
