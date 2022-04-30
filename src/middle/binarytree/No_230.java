package middle.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.230 二叉搜索树中第K小的元素
 */
public class No_230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                k --;
                if (k == 0) return cur.val;
                cur = cur.right;
            }
        }

        return -1;
    }
}
