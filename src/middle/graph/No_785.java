package middle.graph;

import java.util.*;

/**
 * No.785 判断二分图 (Microsoft)
 *
 */
public class No_785 {
    public boolean isBipartite(int[][] graph) {
        //BFS + 染色
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, 0); // 0:uncolored, 1:red, 2:green
        for (int i = 0; i < n; i ++) {
            if (color[i] == 0) {
                Deque<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    int cv = color[u] == 1? 2 : 1;
                    for (int v : graph[u]) {
                        if (color[v] == 0) {
                            color[v] = cv;
                            queue.offer(v);
                        }
                        else if (color[v] != cv) return false; //注意这里也需要防止重复搜索,只在未上色时添加到队列
                    }
                }
            }
        }
        return true;
    }
}
