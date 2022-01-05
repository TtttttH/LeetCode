package com.achui.leetcode.hard.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * No.76 最小覆盖子串
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int tlen = t.length();
        int slen = s.length();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;

        for (int i = 0; i < tlen; i ++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        while (right < slen) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

        }
return null;
    }
}
