package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.1013 将数组分成和相等的三个部分 (Microsoft)
 */
public class No_1013 {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 3 != 0) return false;
        int sum = 0;
        int cnt = 0;
        for (int num : arr) {
            sum += num;
            if (sum == total / 3) {
                sum = 0;
                cnt ++;
            }
        }

        return cnt >= 3;
//        int sum = arr[0];
//        Set<Integer> set = new HashSet<>();
//        set.add(sum);
//        for (int i = 1; i < arr.length - 1; i ++) {
//            sum += arr[i];
//            if (sum % 2 == 0 && set.contains(sum / 2) && (total - sum == sum / 2)) return true;
//            set.add(sum);
//        }
//
//        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(No_1013.canThreePartsEqualSum(arr));
    }
}
