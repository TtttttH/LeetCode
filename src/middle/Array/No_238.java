package middle.Array;

import hard.List.No_23;

/**
 * No.283 除自身以外数组的乘积 (Microsoft)
 */
public class No_238 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
//        int[] post = new int[n];
//        int[] ans = new int[n];
        pre[0] = 1;
//        post[n - 1] = 1;
        for (int i = 1; i < n; i ++) {
            pre[i] = nums[i - 1] * pre[i - 1];
//            post[n - i - 1] = nums[n - i] * post[n - i];
        }

        int postProd = 1;

        for (int i = n - 1; i >= 0; i --) {
//            ans[i] = pre[i] * post[i];
            pre[i] *= postProd;
            postProd *= nums[i];
            System.out.println(pre[i]);
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        No_238.productExceptSelf(nums);
    }
}
