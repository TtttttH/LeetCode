package middle.reservoirSampling;

import java.util.Random;

public class No_382 {
    ListNode head;
    Random random;
    public No_382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode p = head;
        int count = 0;
        int res = p.val;
        while (p!= null) {
            count ++;
            int idx = random.nextInt(count) + 1;
            if (count == idx) res = p.val;
            p = p.next;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int _val) {
        this.val = _val;
    }

    public ListNode(int _val, ListNode _next) {
        this.val = _val;
        this.next = _next;
    }
}
