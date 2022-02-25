package easy.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指offer_54 二叉搜索树的第k个大节点 (微软题)
 */
public class Offer_54 {
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.right;
            }

            cur = deque.pop();
            k--;
            if (k == 0) return cur.val;
            cur = cur.left;
        }
        return 0;
    }
}
