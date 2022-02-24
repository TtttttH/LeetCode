package easy.BinaryTree;

/**
 * No.572 另一棵树的子树 (微软题)
 */
public class No_572 {
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return root.val == subRoot.val && (isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
