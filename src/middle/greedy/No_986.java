package middle.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.986 区间列表的交集 (middle) Microsoft
 */
public class No_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        List<int[] > bet = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            int left = Math.max(first[0], second[0]);
            int right = Math.min(first[1], second[1]);
            if (left <= right) bet.add(new int[]{left, right});
            if (first[1] < second[1]) {
                i ++;
            } else {
                j ++;
            }
        }
        int[][] res = new int[bet.size()][];
        return bet.toArray(res);
//        int[][] res = new int[bet.size()][2];
//        int k = 0;
//        for (int[] b : bet) {
//            res[k ++] = b;
//        }
//
//
//        return res;
    }
}
