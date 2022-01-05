package com.achui.leetcode.middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.222 完全二叉树的节点个数
 */
public class CountNodes_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
//
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offer(root);
//        int result = 0;
//        while (!deque.isEmpty()) {
//            TreeNode cur = deque.poll();
//            if (cur.left != null) {
//                deque.offer(cur.left);
//            }
//
//            if (cur.right != null) {
//                deque.offer(cur.right);
//            }
//            result ++;
//        }
//        return result;
    }
}
