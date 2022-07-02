package middle.binarytree;

/**
 * No.979 在二叉树中分配硬币(Middle) (Microsoft)
 */
public class No_979 {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);

        if (root.left != null) {
            int dis = root.left.val - 1;
            root.left.val = 1;
            root.val += dis;
            res += Math.abs(dis);
        }

        if (root.right != null) {
            int dis = root.right.val - 1;
            root.right.val = 1;
            root.val += dis;
            res += Math.abs(dis);
        }
    }
}
