package easy.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.94 中序遍历（迭代）
 */
public class InorderTravesal_inte {
    public List<Integer> inorderTravesal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
