package middle.List;

/**
 * No.92 反转链表
 */
public class ReverseBetween_92 {
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
        ListNode temp;
        for (int j = left; j < right; j ++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }
}
