package easy.greedy;

import java.util.Arrays;

/**
 * No.252 会议室 (微软)
 */
public class No_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }

        return true;
    }
}
