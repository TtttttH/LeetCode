package com.achui.leetcode.easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 自己再实现一遍
 */
public class InorderTravesal_retry {

    public List<Integer> inorderTravesal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { //一直遍历到左子树叶子节点处
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                results.add(cur.val);
                cur = cur.right;
            }
        }

        return results;
    }
}
