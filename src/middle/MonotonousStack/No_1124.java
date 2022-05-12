package middle.MonotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.1124 表现良好的最长时间段(Microsoft)
 */
public class No_1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int res = 0;
        for (int i = 0; i < n; i ++) {
            hours[i] = hours[i] > 8? 1 : -1;
        }

        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            preSum[i] = preSum[i - 1] + hours[i - 1];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i ++) {
            if (stack.isEmpty() || preSum[stack.peek()] > preSum[i]) stack.push(i);
        }
        int ans = 0;
        for (int i = n; i > 0; i --) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (preSum[i] > preSum[j]) {
                    ans = Math.max(ans, i - j);
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
