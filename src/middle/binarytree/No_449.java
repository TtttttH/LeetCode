package middle.binarytree;

import java.util.List;

/**
 * No.449 序列化和反序列化二叉搜索树 (Microsoft)
 */
public class No_449 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append('#');
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split("#");
        if (strs.length == 0) return null;
        int[] vals = new int[strs.length];
        for (int i = 0; i < strs.length; i ++) {
            vals[i] = Integer.parseInt(strs[i]);
        }

        return dfs(vals, 0, vals.length - 1);
    }

    private TreeNode dfs(int[] vals, int l, int r) {
        if (l > r) return null;
        int val = vals[l];
        TreeNode root = new TreeNode(val);
        int i = l + 1;
        while (i <=r && vals[i] < val) i ++;
        root.left = dfs(vals, l + 1, i - 1);
        root.right = dfs(vals, i, r);

        return root;
    }
}
