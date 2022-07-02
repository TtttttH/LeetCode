package hard.array;

/**
 * No.41 缺失的第一个正数 (Microsoft)
 */
public class No_41 {
    //思路原地哈希
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                //[1, N] 范围内需要移动
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }

        for (int i = 0; i < len ; i ++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;
    }
}
