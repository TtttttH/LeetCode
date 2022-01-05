package com.achui.leetcode.middle.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.429 N叉树的层次遍历
 */
public class NTreeLevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();

        if(root == null) {
            return results;
        }

        deque.offer(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0 ; i < size; i ++) {
                Node cur = deque.poll();
                list.add(cur.val);
                if (cur.children != null) {
                    List<Node> nodes = cur.children;
                    for (Node node : nodes) {
                        deque.offer(node);
                    }
                }
            }

            results.add(list);
        }

        return results;
    }
}
