package middle.List;


/**
 *  No.19 删除链表的倒数第N个结点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(n != 0) {
            fast = fast.next;
            n --;
        }
        if(fast == null) {
            return head.next;
        }
        fast = fast.next;
        while(null != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
//        Map<Integer, ListNode> map = new HashMap<>();
//        ListNode move = head;
//        int count = 1;
//
//        while(move != null) {
//            map.put(count, move);
//            move = move.next;
//            count++;
//        }
//        ListNode preNode = map.get(count - n - 1);
//        if (preNode == null) {
//            head = head.next;
//        } else {
//            preNode.next = preNode.next.next;
//        }
//
//        return head;
}
