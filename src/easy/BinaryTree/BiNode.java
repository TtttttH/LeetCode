package easy.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题17.12 BiNode (Microsoft)
 */
public class BiNode {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode head = new TreeNode(-1);
        TreeNode pre = head;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur.left = null;
            pre.right = cur;
            pre = cur;
            cur = cur.right;
        }

        return head.right;
    }

    TreeNode pre;
    public TreeNode convertBiNode_recursion(TreeNode root) {
        pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode head = pre;
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        root.left = null;
        pre.right = root;
        pre = root;
        dfs(root.right);
    }
}
