package SwordToOffer.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * No.48 最长不含重复字符的子字符串(Microsoft)
 */
public class No_48 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int l = 0;
        for (int r = 0; r < ch.length; r ++) {
            while (set.contains(ch[r])) {
                set.remove(ch[l ++]);
            }
            set.add(ch[r]);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
