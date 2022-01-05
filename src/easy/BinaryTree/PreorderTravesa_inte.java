package com.achui.leetcode.easy.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * No.144 前序遍历（迭代）
 */
public class PreorderTravesa_inte {
    public List<Integer> preorderTravesal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
