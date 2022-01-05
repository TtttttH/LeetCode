package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.513 找树左下角的值
 */
public class FindBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeNode cur = new TreeNode();
        while (!deque.isEmpty()) {
            cur = deque.poll();
            if (cur.right != null) {
                deque.offer(cur.right);
            }

            if (cur.left != null) {
                deque.offer(cur.left);
            }
        }
        return cur.val;
    }
}
