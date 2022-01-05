package com.achui.leetcode.easy.BinaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * No.145 后序遍历（迭代）
 */
public class PostorderTravesal_inte {
    public List<Integer> postorderTravesal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            list.add(cur.val);
        }
        Collections.reverse(list);
        return list;
    }
}
