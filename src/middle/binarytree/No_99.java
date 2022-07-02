package middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.99 恢复二叉搜索树 (Middle)
 */
public class No_99 {
    // TODO Morris遍历
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode p1 = null;
        TreeNode p2 = null;
        for (int i = 0; i < list.size() - 1; i ++) {
            if (list.get(i).val > list.get(i + 1).val) {
                p1 = list.get(i);
                break;
            }
        }

        for (int i = list.size() - 1; i > 0; i --) {
            if (list.get(i).val < list.get(i - 1).val) {
                p2 = list.get(i);
                break;
            }
        }
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
