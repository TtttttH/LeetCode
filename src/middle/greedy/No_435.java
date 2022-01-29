package middle.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.435 无重叠区间
 */
public class No_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if (o1[0] == o2[0]) {
                //     return Integer.compare(o2[1], o1[1]); //起始点相同时优先把右边区间大的放前面，做到遍历时候最优删除
                // }

                return Integer.compare(o1[0], o2[0]);
            }
        });

        int count = 0;
        int edge = intervals[intervals.length - 1][0];
        for (int i = intervals.length - 2; i >=0;  i --) {
            if (intervals[i][1] > edge) {
                count ++;
            } else {
                edge = intervals[i][0];
            }
        }

        return count;
    }
}
