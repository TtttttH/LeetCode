package middle.binarytree;

/**
 * No.538 把二叉搜索树转换为累加树
 */
public class ConvertBST_538 {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        pre = 0;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.right);
        root.val = root.val + pre;
        pre = root.val;
        helper(root.left);
    }
}
