package SwordToOffer.middle;

import java.util.Deque;
import java.util.LinkedList;

public class Offer_36 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(-1, null, null);
        Node pre = dummy;
        Node cur = root;
        Deque<Node> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                pre.right = cur;
                cur.left = pre;
                pre = cur;
                cur = cur.right;
            }
        }

        //连接首尾
        pre.right = dummy.right;
        dummy.right.left = pre;
        return dummy.right;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
