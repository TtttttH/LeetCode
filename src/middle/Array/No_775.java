package middle.Array;

/**
 * No.775 全局倒置与局部倒置 (middle)
 */
public class No_775 {
    public boolean isIdealPermutation(int[] nums) {
        //局部倒置是相邻的特殊全局倒置，所以判断两者是否相等只需要看有没有间隔的全局导致存在
        int len = nums.length;
        if (len <= 2) return true;
        int max = nums[0];
        for (int i = 2; i < len; i ++) {
            if (max > nums[i]) return false;
            max = Math.max(max, nums[i - 1]);
        }

        return true;
    }
}
