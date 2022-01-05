package middle.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  No.637 二叉树的层平均值
 */
public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return results;
        }

        deque.offer(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0 ;
            for (int i = 0; i < size; i ++) {
                TreeNode cur = deque.poll();
                sum = sum +  (double) cur.val;
                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            results.add(sum / size);
        }

        return results;
    }
}
