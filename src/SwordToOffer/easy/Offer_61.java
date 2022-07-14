package SwordToOffer.easy;

import java.util.Arrays;

public class Offer_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        while (nums[zero] == 0) zero ++;
        int distance = 0;
        for (int i = zero + 1; i < 5; i ++) {
            if (nums[i] == nums[i - 1]) return false;
            if (nums[i] - nums[i - 1] > 1) distance += nums[i] - nums[i - 1] - 1;
        }

        return zero >= distance;
    }

    public static void main(String[] args) {
        Offer_61 test = new Offer_61();
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(test.isStraight(nums));
    }
}
