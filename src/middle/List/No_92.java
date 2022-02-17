package middle.List;

/**
 * No.92 反转链表
 */
public class No_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        int i = 0;
        while (i < left) {
            pre = pre.next;
            i ++;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int j = left; j < right; j ++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
