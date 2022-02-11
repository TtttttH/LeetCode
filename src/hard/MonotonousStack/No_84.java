package hard.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.84 柱状图中最大的图形
 */
public class No_84 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length + 1 - 1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < newHeights.length; i ++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int mid = stack.pop();
                int left = stack.peek();
                result = Math.max(result, newHeights[mid] * (i - left - 1));
            }

            stack.push(i);
        }

        return result;
    }
}
