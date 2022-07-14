package SwordToOffer.middle;

import java.util.Arrays;

public class Offer_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
