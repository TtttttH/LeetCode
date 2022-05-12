package middle.topSort;

import java.util.*;

/**
 * No.207 课程表 (Microsoft)
 * 拓扑排序经典题,必会
 */
public class No_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++; // pre[1] is the prerequisite of pre[0]
            map.get(pre[1]).add(pre[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int next : map.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
            i++;
        }

        return i == numCourses;
    }
}
