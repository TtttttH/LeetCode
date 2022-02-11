package hard.MonotonousStack;

import middle.MonotonousStack.No_503;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.42 接雨水 Trapping Rain Water
 */
public class No_42 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>(); // create the stack to store index of height
        int result = 0;
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int low = stack.pop();
                //这里优化思路相当于相等的底层一次性计算
                while (!stack.isEmpty() && height[stack.peek()] == height[low]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && height[stack.peek()] > height[low]) {
                    int left = stack.peek();
                    result += (Math.min(height[left], height[i]) - height[low]) * (i - left - 1);
                }
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        No_42 test = new No_42();
        System.out.println(test.trap(height));
    }
}
