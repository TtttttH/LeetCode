package easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.653 两数之和IV-输入BST
 */
public class No_653 {
    List<TreeNode> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        inOrder(root);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left).val + list.get(right).val;
            if (sum == k) return true;
            else if (sum < k) left ++;
            else right --;
        }
        return false;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}
