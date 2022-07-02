package middle.topSort;

import java.util.*;

/**
 * No.1494 并行课程II(middle)
 */
public class No_1494 {
    //todo
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] indegree = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i ++) {
            map.put(i, new ArrayList<>());
        }
        int res = 0;
        for (int[] relation : relations) {
            indegree[relation[1]] ++;
            map.get(relation[0]).add(relation[1]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i ++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < Math.min(size, k); i ++) {
                int pre = queue.poll();
                for (int next : map.get(pre)) {
                    indegree[next] --;
                    if (indegree[next] == 0) queue.push(next);
                }
            }
            res ++;
        }

        return res;
    }
}
