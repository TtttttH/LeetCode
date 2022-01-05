package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  No.116 填充每个节点的下一个右侧节点指针
 */
public class Connect_116 {
    public Nodel connect(Nodel root) {
        Deque<Nodel> deque = new LinkedList<>();
        if (root == null) {
            return root;
        }

        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size-1; i ++) {
                Nodel cur = deque.poll();
                cur.next = deque.peek();
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            Nodel cur = deque.poll();
            if (cur.left != null) {
                deque.offer(cur.left);
            }
            if (cur.right != null) {
                deque.offer(cur.right);
            }
        }
        return root;
    }
}
