package easy.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.606 根据二叉树创建字符串
 */
public class No_606 {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (!left.equals("") && !right.equals("")) {
            sb.append('(').append(left).append(")(").append(right).append(')');
        } else if (left.equals("") && !right.equals("")) {
            sb.append("()(").append(right).append(')');
        } else if (!left.equals("")) {
            sb.append('(').append(left).append(')');
        }

        return sb.toString();
    }
}
