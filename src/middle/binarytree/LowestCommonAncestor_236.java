package middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *  No.236 二叉树的最近公共祖先
 */
public class LowestCommonAncestor_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right == null) {
            return left;
        }

        if (left == null && right != null) {
            return right;
        }

        return root;
    }
}
