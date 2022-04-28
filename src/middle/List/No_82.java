package middle.List;

/**
 * No.82 删除排序链表中的重要元素II
 */
public class No_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!= null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur =cur.next;
        }

        return dummy.next;
    }
}
