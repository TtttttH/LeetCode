package middle.doublepoint;

import java.util.Arrays;

/**
 * No.16: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumCloest {
    public static int threeSumCloest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    r --;
                } else if (sum < target) {
                    l ++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, -3};
        System.out.printf("a = "  + threeSumCloest(arr, 1) + "\n");
    }
}
