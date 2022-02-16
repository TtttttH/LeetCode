package middle.List;

/**
 * No.61 旋转链表 (middle)
 */
public class No_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 1; //初始化链表长度计数
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length ++;
        }

        k %= length; //去掉多余的旋转轮数，既为最后需要截掉的节点数
        if (k == 0) {
            return head;
        }

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i ++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        cur.next = head;
        return newHead;
    }
}
