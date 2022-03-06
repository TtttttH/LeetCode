package middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.129 求根节点到叶节点的数字之和 (middle) 微软
 */
public class No_129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        getPaths(root, 0);
        return sum;
    }

    private void getPaths(TreeNode root, int pathNumber) {
        pathNumber = pathNumber * 10 + root.val;
        if (root.left == null && root.right == null) sum += pathNumber;
        if (root.left != null) getPaths(root.left, pathNumber);
        if (root.right != null) getPaths(root.right, pathNumber);
    }
}
