package middle.binarytree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  自底向上层次遍历 II
 */
public class LevelOrder_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return results;
        }

        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i ++) {// 这里注意一定要固定循环的次数，不能直接调用deque.size
                TreeNode cur = deque.poll();
                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }

                list.add(cur.val);
            }
            results.add(list);
        }
        Collections.reverse(results);
        return results;
    }
}
