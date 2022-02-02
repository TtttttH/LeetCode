package middle.Array;

import java.util.Arrays;

/**
 * No.31 Next Permutation
 */
public class No_31 {
    public void nextPermutation(int[] nums) {
        int temp = 0;
        int len = nums.length;
        for (int i = len - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                for (int j = len - 1; j >= i; j --) {
                    if (nums[j] > nums[i - 1]) {
                        temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        Arrays.sort(nums, i, len);
                        return;
                    }
                }
            }
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        No_31 test = new No_31();
        test.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
