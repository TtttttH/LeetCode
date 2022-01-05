package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.242 有效的字母异味词
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] record = new int[26];
        for (Character c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (Character c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
