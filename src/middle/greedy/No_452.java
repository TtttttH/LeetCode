package middle.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.452
 */
public class No_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });
        int currentStart = points[0][0];
        int count = 1;
        for (int i = 1; i < points.length; i ++) {
            if (points[i][1] < currentStart) {
                currentStart = points[i][0];
                count ++;
            }
        }

        return count;
    }
}
