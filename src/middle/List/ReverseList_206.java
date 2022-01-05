package middle.List;
/**
 * No.206
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
