package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.510 二叉搜索树中的中序后继II (Microsoft)
 */
public class No_510 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        /**
         * 思路:当node有右子节点的时候，优先找到右子树上的最左节点
         *      无右子树的话，找node节点的父节点，找到第一个大于node的父节点为止，如果直到根节点都没有的话，返回空
         */
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }

        while (node.parent != null) {
            if (node.parent.val > node.val) {
                return node.parent;
            }

            node = node.parent;
        }

        return null;
    }
}
