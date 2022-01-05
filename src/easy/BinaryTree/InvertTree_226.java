package com.achui.leetcode.easy.BinaryTree;

/**
 * No.226 翻转二叉树
 */
public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
