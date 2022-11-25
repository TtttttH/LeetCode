package SwordToOffer.easy;

public class Offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }
}
