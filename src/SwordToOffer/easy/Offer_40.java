package SwordToOffer.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[]{};
        if(k == arr.length) return arr;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : arr) {
            if (queue.size() < k) queue.add(num);
            else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i ++] = queue.poll();
        }
        return res;
    }
}
