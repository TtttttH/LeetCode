package easy.BinaryTree;

/**
 * No.700 二叉搜索树中的搜索
 */
public class SearchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return root.val < val? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
