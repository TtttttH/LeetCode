package middle.binarytree;

/**
 * No.669 修剪二叉搜索树
 */
public class TrimBST_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }

        if (root.val < low) {
            //可以精简成 return trimBST(root.right, low, high);,节约很多空间
            root.left = null;
            root = trimBST(root.right, low, high);
        } else {
            root.right = null;
            root = trimBST(root.left, low, high);
        }

        return root;
    }
}
