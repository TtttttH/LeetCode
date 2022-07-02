package middle.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.962 最大宽度坡 (Microsoft)
 */
public class No_962 {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = n - 1; i >= 0; i --) {
            if (stack.isEmpty()) break;
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) res = Math.max(res, i - stack.pop());
        }
        return res;
    }
}
