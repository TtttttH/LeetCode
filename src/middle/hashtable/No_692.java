package middle.hashtable;

import java.util.*;

/**
 * No.692 前K个高频单词 (微软题)
 */
public class No_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            return count1 == count2 ? o2.compareTo(o1) : count1 - count2;
        });

        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) queue.poll();
        }

        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) res.add(queue.poll());

        Collections.reverse(res);
        return res;
    }
}
