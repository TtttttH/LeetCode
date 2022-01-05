package easy.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.101: 对称二叉树
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            deque.offer(node1.left);
            deque.offer(node2.right);
            deque.offer(node1.right);
            deque.offer(node2.left);
        }

        return true;
    }
}
