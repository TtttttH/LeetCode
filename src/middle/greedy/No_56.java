package middle.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.56 Merge Intervals
 */
public class No_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                result.add(intervals[i - 1]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        return result.toArray(new int[result.size()][]);
    }
}
