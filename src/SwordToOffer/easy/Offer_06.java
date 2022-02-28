package SwordToOffer.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Offer.06 从尾到头打印链表
 */
public class Offer_06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        int[] res = new int[len];
        cur = head;
        while (cur != null) {
            len --;
            res[len] = cur.val;
            cur = cur.next;
        }

        return res;
    }
}
