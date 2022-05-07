package middle.sort;

import java.util.Arrays;

/**
 * No.324 摆动排序II (Microsoft)
 */
public class No_324 {
    public void wiggleSort(int[] nums) {
        //计数排序
        int[] count = new int[5001];
        for (int num : nums) count[num] ++;
        int n = 5000;
        for (int i = 1; i < nums.length; i += 2) {
            while (count[n] == 0) n --;
            nums[i] = n;
            count[n] --;
        }

        for (int i = 0; i < nums.length; i += 2) {
            while (count[n] == 0) n --;
            nums[i] = n;
            count[n] --;
        }
//        int[] help = Arrays.copyOf(nums, nums.length); //O(n logn)
//        Arrays.sort(help);
//        int n = nums.length;
//        for (int i = 1; i < nums.length; i += 2) {
//            nums[i] = help[-- n];
//        }
//
//        for (int i = 0; i < nums.length; i += 2) {
//            nums[i] = help[-- n];
//        }
    }
}
