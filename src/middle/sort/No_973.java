package middle.sort;

import java.util.PriorityQueue;

/**
 * No.973 最接近原点的K个点(Microsoft)
 */
public class No_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);
        for (int[] point : points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.poll();
        }

        return res;
    }
}
