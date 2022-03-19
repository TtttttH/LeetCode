package easy.BinaryTree;

import java.util.*;

/**
 * No.606 根据二叉树创建字符串
 */
public class No_606 {
    public String tree2str(TreeNode root) {
//        if (root == null) return "";
//        StringBuilder sb = new StringBuilder();
//        sb.append(root.val);
//        String left = tree2str(root.left);
//        String right = tree2str(root.right);
//        if (!left.equals("") && !right.equals("")) {
//            sb.append('(').append(left).append(")(").append(right).append(')');
//        } else if (left.equals("") && !right.equals("")) {
//            sb.append("()(").append(right).append(')');
//        } else if (!left.equals("")) {
//            sb.append('(').append(left).append(')');
//        }
//
//        return sb.toString();
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (visited.contains(node)) {
                if (node != root) sb.append(')');
            } else {
                visited.add(node);
                if (node != root) sb.append('(');
                sb.append(root.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left == null && right != null) {
                    sb.append("()");
                }

                if (right != null) {
                    deque.push(right);
                }

                if (left != null) {
                    deque.push(left);
                }
            }
        }

        return sb.toString();
    }
}
