package middle.List;

/**
 * 程序员面试精典02_05 (Microsoft)
 */
public class No_02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null || l2 != null || add != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + add;
            add = val / 10;
            val %= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }

        return head.next;
    }
}
