package middle.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.253 会议室II (微软)
 */
public class No_253 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i ++) {
            if (queue.peek() <= intervals[i][0]) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }

        return queue.size();
//        int n = intervals.length;
//        int[] start = new int[n];
//        int[] end = new int[n];
//        for (int i = 0; i < n; i ++) {
//            start[i] = intervals[i][0];
//            end[i] = intervals[i][1];
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        int endIdx = 0;
//        int cnt = 0;
//        for (int time : start) {
//            if (time < end[endIdx]) cnt ++;
//            else endIdx ++;
//        }
//
//        return cnt;
    }
}
