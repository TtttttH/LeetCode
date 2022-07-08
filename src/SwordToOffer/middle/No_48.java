package SwordToOffer.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.48 最长不含重复字符的子字符串(Microsoft)
 */
public class No_48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0, left = -1;
        for (int right = 0; right < chars.length; right ++) {
            if (map.containsKey(chars[right])) {
                left = Math.max(left, map.get(chars[right]));
            }

            map.put(chars[right], right);
            res = Math.max(res, right - left);
        }

        return res;
    }
}
