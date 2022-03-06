package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.173 二叉搜索树迭代器
 */
public class BSTIterator {
    TreeNode cur;
    Deque<TreeNode> stack = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        this.cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }
    public boolean hasNext() {
        return cur != null || !this.stack.isEmpty();
    }
}
