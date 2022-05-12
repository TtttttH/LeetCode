package middle.List;

/**
 * No.328 奇偶链表(Microsoft)
 */
public class No_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
//        ListNode odd = head;
//        ListNode even = head.next;
//        ListNode oddEnd = null;
//        ListNode evenHead = even;
//        while (odd != null && odd.next != null) {
//            even = odd.next;
//            odd.next = odd.next.next;
//            if (even.next != null) even.next = even.next.next;
//            oddEnd = odd;
//            odd = odd.next;
//        }
//        if (odd != null) oddEnd = odd;
//        oddEnd.next = evenHead;
//        return head;
    }
}
