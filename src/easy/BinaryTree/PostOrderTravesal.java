package easy.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * No.145 后续遍历
 */
public class PostOrderTravesal {
    public List<Integer> ppstOrderTravesal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        travesal(list, root);
        return list;
    }

    private void travesal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return ;
        }
        travesal(list, root.left);
        travesal(list, root.right);
        list.add(root.val);
    }
}
