package middle.stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * No.1249 移除无效的括号(Microsoft)
 */
public class No_1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length();
        boolean[] valid = new boolean[n];
        Arrays.fill(valid, true);
        for (int i = 0; i < n; i ++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(i);
            if (ch == ')') {
                if (stack.isEmpty()) valid[i] = false;
                else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            valid[stack.pop()] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (valid[i]) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
