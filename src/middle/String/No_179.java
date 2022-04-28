package middle.String;

import java.util.Arrays;

/**
 * No.179 最大数 (Microsoft)
 */
public class No_179 {
    public String largestNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i ++) {
//            int max = i;
//            for (int j = i + 1; j < nums.length; j ++) {
//                String s1 = String.valueOf(nums[max]);
//                String s2 = String.valueOf(nums[j]);
//                if((s1 + s2).compareTo(s2 + s1) < 0) max = j;
//            }
//
//            int temp = nums[i];
//            nums[i] = nums[max];
//            nums[max] = temp;
//        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, ((s1, s2) -> (s2 + s1).compareTo(s1 + s2)));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k ++;
        return sb.substring(k);
    }
}
