package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1189 balloon的最大数量
 */
public class No_1189 {
    public int maxNumberOfBalloons(String text) {
            if (text.length() < 7) {
                return 0;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : text.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 1) + 1);
            }

            int[] balloon = new int[5];
            balloon[0] = map.getOrDefault('b', 0);
            balloon[1] = map.getOrDefault('a', 0);
            balloon[2] = map.getOrDefault('l', 0) / 2;
            balloon[3] = map.getOrDefault('o', 0) / 2;
            balloon[4] = map.getOrDefault('n', 0);

            int res = Integer.MAX_VALUE;
            for (int i : balloon) {
                res = Math.min(res, i);
            }

            return res;
    }
}
