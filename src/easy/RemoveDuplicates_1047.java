package com.achui.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicates_1047 {
    public String removeDuplicates(String s) {
        Deque<Character> queue = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!queue.isEmpty() && ch == queue.peek()) {
                queue.pop();
            } else {
                queue.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates_1047 removeclass = new RemoveDuplicates_1047();
        String s = "abbaca";
        System.out.println(removeclass.removeDuplicates(s));
    }
}
