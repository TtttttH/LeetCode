package easy.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.589 N叉树的前序遍历
 */
public class No_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i --) {
                stack.push(children.get(i));
            }
        }
        
        return res;
    }
}
