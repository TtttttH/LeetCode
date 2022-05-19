package middle.dp;

import java.util.PriorityQueue;

/**
 * No.1642 可以到达的最远建筑(Microsoft)
 */
public class No_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        for (int i = 1; i < heights.length; i ++) {
            if (heights[i] > heights[i - 1]){
                int jump = heights[i] - heights[i - 1];
                queue.offer(jump);
                if (queue.size() > ladders) {
                    bricks -= queue.poll();
                }
                if (bricks < 0) return i - 1;
            }
        }

        return heights.length - 1;
    }
}
