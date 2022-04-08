package middle.Array;

import java.util.Arrays;

/**
 * No.189 轮转数组 (Microsoft)
 */
public class No_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) { //[start, end]
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        No_189 test = new No_189();
        test.rotate(nums, 3);
    }
}
