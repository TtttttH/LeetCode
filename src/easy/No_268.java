package easy;

/**
 * No.268 丢失的数字 (Microsoft)
 */
public class No_268 {
    public int missingNumber(int[] nums) {
        //O(N) 空间O(1)思路: 异或位运算，类似于只出现一次的数字那题
        int res = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
//        int sum = nums[0], n = nums.length;
//        for (int i = 1; i < n; i ++) {
//            sum ^= nums[i];
//        }
//
//        for (int i = 0 ; i <= n; i ++) {
//            sum ^= i;
//        }
//
//        return sum ;
    }

    public static void main(String[] args) {
        int[] nums = {9,7,6,5,4,3,2,1,0};
        No_268 test=  new No_268();
        System.out.println(test.missingNumber(nums));
    }
}
