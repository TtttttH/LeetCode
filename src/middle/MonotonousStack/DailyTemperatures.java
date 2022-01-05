package com.achui.leetcode.middle.MonotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.739 Daily Temperatures
 * Deque是双向队列，可以替代模拟栈的效果，注意push和add方法的区别，push是从队首插入相当于入栈，add是队尾，相当于入队
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = temperatures.length;
        int[] res = new int[length];
        for(int i = 0; i < length; i ++) {
            res[i] = 0;
        }
        for (int i = 0; i < temperatures.length; i ++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while(stack.size() > 0 && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                System.out.println("元素出栈: " + stack.peek());
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        DailyTemperatures dt = new DailyTemperatures();
        for (int i: dt.dailyTemperatures(temp)) {
            System.out.println(i);
        }
    }
}
