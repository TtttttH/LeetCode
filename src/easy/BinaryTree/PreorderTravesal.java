package com.achui.leetcode.easy.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * No.144 二叉树前序遍历
 */
public class PreorderTravesal {
    public List<Integer> preorderTravesal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        travesal(result, root);
        return result;
    }

    private void travesal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return ;
        }
        list.add(node.val);
        travesal(list, node.left);
        travesal(list, node.right);
    }
}
