package com.achui.leetcode.middle.slideingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * No.3 无重复字符的最长子串
 */
public class LengthOfLongestSubString {
    public int lenthOfLongestSubString(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        Set<Character> set = new HashSet<>();
        int rk = -1; //滑动窗口指针
        for(int i = 0; i < n; i ++) {
            if(i > 0) {
                //进入下一轮循环的前提是遇到重复单词，及下一个单词和句首单词相同，故i > 0时要去掉set中的这个句首单词
                set.remove(s.charAt(i - 1));
            }

            while(rk + 1 < n && !set.contains(s.charAt((rk + 1)))) {
                rk ++;
                set.add(s.charAt(rk));
            }
            res = Math.max(res, rk - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString ls = new LengthOfLongestSubString();
//        String s = "pwwkew";
//        String s = "bbbbb";
        String s = "abcabcbb";
        System.out.printf("res : " + ls.lenthOfLongestSubString(s));
    }
}
