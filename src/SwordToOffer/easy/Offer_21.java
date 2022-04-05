package SwordToOffer.easy;

/**
 * No.21 调整数组顺序使奇数位于偶数前面
 */
public class Offer_21 {
    public int[] exchange(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) start ++;
            while (start < end && nums[end] % 2 == 0) end --;
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
//        while (start < end) {
//            if (nums[start] % 2 == 1) {
//                start ++;
//            } else {
//                int temp = nums[end];
//                nums[end] = nums[start];
//                nums[start] = temp;
//                end --;
//            }
//        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,2,5,6};
        Offer_21 test = new Offer_21();
        test.exchange(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
