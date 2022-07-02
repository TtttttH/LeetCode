package SwordToOffer.middle;

/**
 * No.56 数组中数字出现的次数II (Microsoft)
 */
public class Offer_56 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < 32; j ++) {
                bits[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i ++) {
            bits[31 - i] %= 3;
            res |= bits[31 - i];
            res = res << 1;
        }

        return res;
    }
}
