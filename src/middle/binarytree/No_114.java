package middle.binarytree;

/**
 * No.114 二叉树展开为链表 (middle) 微软
 */
public class No_114 {
    public void flatten (TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode right = root.right;
        TreeNode cur = root.left;
        if (cur != null) {
            while (cur.right != null) cur = cur.right;
            cur.right = right;
            root.right = root.left;
            root.left = null;
        }
        flatten(right);
    }
}
