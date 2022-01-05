package com.achui.leetcode.middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的层序遍历
 */
public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return results;
        }

        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
                list.add(cur.val);
            }
            results.add(list);
        }

        return results;
    }
}
