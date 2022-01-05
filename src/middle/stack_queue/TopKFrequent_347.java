package middle.stack_queue;

import java.util.*;

/**
 * No.347 前K个高频元素
 */
public class TopKFrequent_347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[] {key, count});
                }
            } else {
                queue.offer(new int[] {key, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}
