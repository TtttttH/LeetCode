package middle.topSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.210 课程表II (Microsoft)
 */
public class No_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> relation= new ArrayList<>();
        for (int i = 0; i < numCourses; i ++) {
            relation.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            inDegree[pre[0]] ++;
            relation.get(pre[1]).add(pre[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses;i ++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[i ++] = pre;
            for (int course : relation.get(pre)) {
                inDegree[course] --;
                if (inDegree[course] == 0) queue.add(course);
            }
        }

        return i == numCourses ? res : new int[]{};
    }
}
