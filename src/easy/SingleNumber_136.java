package easy;

/**
 * No.136 只出现一次的数字
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
