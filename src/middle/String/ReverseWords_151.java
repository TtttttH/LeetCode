package com.achui.leetcode.middle.String;

/**
 * No.151 reverseWords
 */
public class ReverseWords_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ') {
            start ++;
        }

        while(s.charAt(end) == ' ') {
            end --;
        }

        while(end >= start) {
            if (s.charAt(end) != ' ') {
                int temp = end;
                while (end >= start && s.charAt(end) != ' ') {
                    end --;
                }
                sb.append(s.substring(end + 1 , temp + 1));
            } else {
                sb.append(' ');
                while (end >= start && s.charAt(end) == ' ') {
                    end --;
                }
            }
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWords_151 rw = new ReverseWords_151();
        System.out.println(rw.reverseWords(s));
    }
}
