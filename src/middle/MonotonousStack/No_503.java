package middle.MonotonousStack;

import java.util.*;

/**
 * No.503 Next Greater Element II
 */
public class No_503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
//        for (int i = 0; i < len; i ++) {
//            ans[i] = -1;
//        }
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * len; i ++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = nums[i % len];
            }
            if (i < len) stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        No_503 test = new No_503();
        int[] ans = test.nextGreaterElements(nums);
        for (int i : ans) {
            System.out.print(i + ",");
        }
    }
}
