package com.achui.leetcode.easy.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.104 二叉树最大深度
 */
public class MaxDepth_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            depth ++;
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                TreeNode cur = deque.poll();
                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }

        return depth;
    }
}
