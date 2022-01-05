package hard.queue_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.239 滑动窗口最大值
 */
public class MaxSlidingWindow_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>  deque = new LinkedList<>();
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i ++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
