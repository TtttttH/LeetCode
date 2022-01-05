package com.achui.leetcode.easy.BinaryTree;

/**
 * No.404 左叶子之和
 */
public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int value = 0;
        if (root.left != null && root.left.left == null && root.right.right == null) {
            value = root.left.val;
        }

        return value + leftValue + rightValue;
    }

}
