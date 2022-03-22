package middle.List;

import java.util.PriorityQueue;

/**
 * No.148 排序链表 (微软)
 */
public class No_148 {
    //TODO 需要归并排序优化
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.val, o2.val)));
        while (head != null) {
            queue.add(head);
            head = head.next;
        }

        head = queue.peek();
        ListNode cur = queue.poll();
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        if (cur.next != null) cur.next = null;
        return head;
    }
}
