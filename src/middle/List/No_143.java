package middle.List;

/**
 * No.143 重排链表 (Microsoft)
 */
public class No_143 {
    /**
     * 思路：快慢指针找到中点截断，翻转后半段链表，再双指针平移插入节点
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode pre = head;
        ListNode p = head.next;
        ListNode q = head.next.next;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }

        pre = p;
        p = p.next;
        pre.next = null;
        pre = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        ListNode cur = head;
        while (cur != null && pre != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = pre.next;
            cur.next = pre;
            pre.next = temp1;
            cur = temp1;
            pre = temp2;
        }
    }
}
