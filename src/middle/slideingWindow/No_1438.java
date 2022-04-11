package middle.slideingWindow;

import java.util.Deque;
import java.util.LinkedList;


/**
 * No.1438 绝对差不超过限制的最长连续子数组 (Microsoft)
 */
public class No_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int left = 0;
        int right = 0;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        while (right < nums.length) {
            while (!max.isEmpty() && max.peekLast() < nums[right]) max.pollLast();
            while (!min.isEmpty() && min.peekLast() > nums[right]) min.pollLast();
            min.offerLast(nums[right]);
            max.offerLast(nums[right]);
            while (!min.isEmpty() && !max.isEmpty() && (max.peekFirst() - min.peekFirst() > limit)) {
                if (max.peekFirst() == nums[left]) max.pollFirst();
                if (min.peekFirst() == nums[left]) min.pollFirst();
                left ++;
            }

            res = Math.max(res, right - left + 1);
            right ++;
        }

        return res;
    }
}
