package easy;

/**
 * No.169 多数元素 (leetcode top100)
 */
public class No_169 {
    //摩尔投票
    public int majorityElement(int[] nums) {
        int count = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (count == 0) res = num;
            if (res == num) count++;
            else {
                count--;
            }
        }

        return res;
    }
}
