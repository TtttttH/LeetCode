package middle.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15: 给定一个包含n个整数的数组 nums,判断nums中是否存在三个数a, b, c 的和为0
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return resList;
            }
            if(i > 0 && nums[i-1] == nums[i]) {
                //需要和上一次枚举的数不同
                continue;
            }
            int right = nums.length - 1;
            for(int left = i + 1; left < nums.length - 1; left ++) {
                if(left > i + 1 && nums[left] == nums[left-1]) {
                    continue;
                }
                while(left < right && nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                }
                if (left == right) {
                    break; // 因为这里nums[i] + nums[left] + nums[left + 1] 一定还是大于0的，那么再循环left + 1也不会有 = 0 的数再出现了
                }
                if (nums[i] + nums[left] + nums[right]  == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resList.add(list);
                }
            }
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum < 0) {
//                    left ++;
//                }
//                else if (sum > 0) {
//                    right --;
//                } else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[left]);
//                    list.add(nums[right]);
//                    if (!resList.contains(list)) {
//                        resList.add(list);
//                    }
//                    left ++;
//                    right --;
//                }
//            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.printf(ts.threeSum(nums).toString());
    }
}