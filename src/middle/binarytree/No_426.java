package middle.binarytree;

/**
 * No.426 将二叉搜索树转化为排序的双向链表 (Microsoft)
 */
public class No_426 {
    Node_ pre;
    public Node_ treeToDoublyList(Node_ root) {
        if (root == null || root.left == null && root.right == null) return root;
        Node_ head = new Node_(-1001);
        pre = head;
        dfs(root);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }

    private void dfs(Node_ root) {
        if (root == null) return;
        dfs(root.left);
        root.left = pre;
        pre.right = root;
        pre = root;
        dfs(root.right);
    }
}

class Node_{
    public int val;
    public Node_ left;
    public Node_ right;
    public Node_(int val) {
        this.val = val;
    }
    public Node_(int val, Node_ left, Node_ right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
