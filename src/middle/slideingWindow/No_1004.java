package middle.slideingWindow;

/**\
 * No.1004 最大连续1的个数III(Microsoft)
 * 滑动窗口经典题!!
 */
public class No_1004 {
    public int longestOnes(int[] nums, int k) {
        int lzero = 0, rzero = 0, left = 0, res = 0;
        for (int r = 0; r < nums.length; r ++) {
            rzero += 1 - nums[r];
            while (lzero < rzero - k) {
                lzero += 1 - nums[left ++];
            }

            res = Math.max(r - left + 1, res);
        }

        return res;

//        int zero = 0;
//        int res = 0;
//        int len = nums.length;
//        int left = 0;
//        for (int r = 0; r < len; r ++) {
//            if (nums[r] == 0) zero ++;
//            if (zero > k) {
//                while (nums[left] == 1) left ++;
//                zero --;
//                left ++;
//            }
//
//            res = Math.max(res, r - left + 1);
//        }
//
//        return res;
    }
}
