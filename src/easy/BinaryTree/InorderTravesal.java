package easy.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * No.94 二叉树中序遍历
 */
public class InorderTravesal {
    public List<Integer> inorderTravesal (TreeNode root) {
        List<Integer> list = new LinkedList<>();
        travesal(list, root);
        return list;
    }

    private void travesal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return ;
        }

        travesal(list, node.left);
        list.add(node.val);
        travesal(list, node.right);
    }
}
