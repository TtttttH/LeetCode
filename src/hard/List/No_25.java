package hard.List;

/**
 * No.25 K个一组反转链表(高频题!)
 */
public class No_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode tail = head;
        ListNode temp; // 用于存储下一次的start
        while (tail != null) {
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return dummy.next;
                }
                tail = tail.next;
            }

            temp = start.next;
            reverse(start, tail); //双开区间
            start = temp;
        }

        return dummy.next;
    }

    private void reverse(ListNode start, ListNode tail) {
        ListNode cur = start.next;
        ListNode next;
        while (cur.next != tail) {
            next = cur.next;
            cur.next = next.next;
            next.next = start.next;
            start.next = next;
        }
    }
}
