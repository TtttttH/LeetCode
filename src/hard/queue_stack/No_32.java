package hard.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * No.32 最长有效括号数
 */
public class No_32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); //注意这里栈不能存括号，只能存index
        int[] valid = new int[s.length()];
        Arrays.fill(valid, 1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i ++) {
            if (!stack.isEmpty() && chars[i] == ')' && chars[stack.peek()] == '(') {
                valid[stack.pop()] = 0;
                valid[i] = 0;
            } else {
                stack.push(i);
            }
        }

        int maxContinueZero = 0;
        int count = 0;
        for (int j : valid) {
            if (j == 1) {
                count = 0;
            } else {
                count++;
                maxContinueZero = Math.max(maxContinueZero, count);
            }
        }

        return maxContinueZero;
    }
}
