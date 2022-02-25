package middle.binarytree;

import java.util.*;

/**
 * No.103 二叉树的锯齿形层次遍历
 */
public class No_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean flag = false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
                list.add(node.val);
            }

            if (flag) Collections.reverse(list);
            flag = !flag;
            res.add(list);
        }

        return res;
    }
}
