package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1791 找出星型图的中心节点
 */
public class No_1791 {
    public int findCenter(int[][] edges) {
        int i = edges[0][0];
        int j = edges[0][1];
        int k = edges[1][0];
        int m = edges[1][1];
        if (i == k || i == m) {
            return i;
        } else {
            return j;
        }
//        Map<Integer, Integer> connects = new HashMap<>();
//        for (int i = 0; i < edges.length; i ++) {
//            connects.put(edges[i][0], connects.getOrDefault(edges[i][0], 0) + 1);
//            connects.put(edges[i][1], connects.getOrDefault(edges[i][1], 0) + 1);
//        }
//
//        for (int i : connects.keySet()) {
//            if (connects.get(i) == edges.length) {
//                return i;
//            }
//        }
//
//        return -1;
    }
}
