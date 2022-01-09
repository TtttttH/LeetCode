package easy.BinaryTree;

/**
 * No.235 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p ,q);
        }

        return root;
    }
}
