package hard.List;

import java.util.ArrayList;
import java.util.List;

/**
 * No.23 合并K个升序链表 (hard)
 */
public class No_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode preNode;
        for (ListNode cur : lists) {
            preNode = dummy.next;
            if (preNode == null) {
                dummy.next = cur;
            } else {
                while (cur != null) {
                    while (preNode.next != null && preNode.val < cur.val) {
                        preNode = preNode.next;
                    }

                    if (preNode.next == null) {
                        preNode.next = cur;
                        break;
                    } else {
                        ListNode temp = preNode.next;
                        preNode.next = cur;
                        cur = cur.next;
                        preNode.next.next = temp;
                        preNode = preNode.next;
                    }
                }
            }
        }

        return dummy.next;
    }
}
