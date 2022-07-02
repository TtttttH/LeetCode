package middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.988 从叶节点开始的最小字符串 (Microsoft)
 */
public class No_988 {
    StringBuilder sb = new StringBuilder();
    String result = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        sb.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String s = sb.reverse().toString();
            sb.reverse();
            if (result.compareTo(s) > 0) result = s;
//            return; 这里不可以return!
        }


        if(root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
