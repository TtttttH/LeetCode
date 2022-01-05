package middle.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.199 二叉树右视图
 */
public class RightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return results;
        }

        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                TreeNode cur = deque.poll();
                if (i == size - 1) {
                    results.add(cur.val);
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }

        return results;
    }
}
