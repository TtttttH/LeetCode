package contest.cmbchina;

import java.util.HashMap;
import java.util.Map;

public class Solution_2 {
    public int numFlowers(int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0) + 1);
        }

        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        return max + 1;
    }
}
