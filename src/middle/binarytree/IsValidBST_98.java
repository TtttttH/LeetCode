package middle.binarytree;

/**
 * No.98 验证二叉搜索树
 */
public class IsValidBST_98 {

    TreeNode max;

    //思路：中序遍历，判断遍历节点值是否始终递增
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (max != null && root.val <= max.val) {
            return false;
        }

        max = root;

        boolean right = isValidBST(root.right);
        return right;
    }
}
