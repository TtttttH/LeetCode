package middle.doublepoint;

/**
 *  No.75 颜色排序 双指针法
 */
public class No_75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;

        for (int i = 0; i < n; i ++) {
            //如果是2就置换到最后
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2 --;
            }
            //如果i位置是0，置换到最前p0处
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0 ++;
            }
        }
    }
}
