package middle.List;

/**
 * No.142 环形链表
 */
public class DetectCycle_142 {
    public ListNode detectCycle (ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode node = head;
                while (fast != node) {
                    fast = fast.next;
                    node = node.next;
                }
                return node;
            }
        }
        return null;
    }
}
