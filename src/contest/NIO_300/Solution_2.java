package contest.NIO_300;

import java.util.Arrays;

/**
 * 螺旋矩阵IV
 */
public class Solution_2 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] r : res) {
            Arrays.fill(r, -1);
        }
        int loop = Math.min(m, n) / 2;
        int t = 0;
        while (head != null && t <= loop) {
            for (int j = t; head != null && j < n - t; j ++) {
                res[t][j] = head.val;
                head = head.next;
            }

            for (int i = t + 1; head != null && i < m - t; i ++) {
                res[i][n - t - 1] = head.val;
                head = head.next;
            }

            for (int j = n - t - 2; head != null && j >= t; j --) {
                res[m - t - 1][j] = head.val;
                head = head.next;
            }

            for (int i = m - t - 2; head != null && i > t; i --) {
                res[i][t] = head.val;
                head = head.next;
            }

            t ++;
        }

        return res;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
