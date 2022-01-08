package easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.530 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference_530 {

    TreeNode pre;
    int result = Integer.MAX_VALUE;
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }

        pre = root;
        traversal(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traversal(root);
        return result;
    }
//    List<Integer> list = new ArrayList<>();
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        traversal(root);
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < list.size() - 1; i ++) {
//            result = Math.min(result, list.get(i + 1) - list.get(i));
//        }
//
//        return result;
//    }
//
//    private void traversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        traversal(root.left);
//        list.add(root.val);
//        traversal(root.right);
//    }
}
