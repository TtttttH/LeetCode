package middle.Hash;

import java.util.*;

/**
 * No.5235 找出输掉零场或一场比赛的玩家 (middle)
 */
public class No_5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.put(match[0], map.getOrDefault(match[0], 0));
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.containsKey(key)) {
                if (map.get(key) == 0) list0.add(key);
                else if (map.get(key) == 1) list1.add(key);
            }
        }

        Collections.sort(list0);
        Collections.sort(list1);
        res.add(list0);
        res.add(list1);
        return res;
    }
}
