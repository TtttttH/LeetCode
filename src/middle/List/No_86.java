package middle.List;

/**
 * No.86 分隔链表l(middle)
 * @Date 2022.2.16 Wed
 */
public class No_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode preSmall = small;
        ListNode preLarge = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                preSmall.next = cur;
                preSmall = preSmall.next;
            } else {
                preLarge.next = cur;
                preLarge = preLarge.next;
            }
            cur = cur.next;
        }
        preLarge.next = null;
        preSmall.next = large.next;
        return small.next;
    }
}
