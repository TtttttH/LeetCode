package easy.BinaryTree;

import java.util.*;

/**
 * No.590 N叉树的后序遍历
 */
public class No_590 {
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> postorder(Node root) {
//        if (root == null) return list;
//        for (Node child : root.children) {
//            postorder(child);
//        }
//
//        list.add(root.val);
//        return list;
//    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }

        Collections.reverse(list);
        return list;
    }
}
