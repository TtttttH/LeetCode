package middle.Array;

import java.util.*;

/**
 * No.384 打乱数组 （Microsoft)
 */
public class No_384 {
    int[] origin;
    int[] cur;
    public No_384(int[] nums) {
        origin = nums;
        cur = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        cur = Arrays.copyOf(origin, origin.length);
        return origin;
    }

    public int[] shuffle() {
        //洗牌算法
        Random rand = new Random();
        for (int i = 0; i < cur.length; i ++) {
            int j = i + rand.nextInt(cur.length - i);
            int temp = cur[j];
            cur[j] = cur[i];
            cur[i] = cur[j];
        }

        return cur;
//        int[] ans = new int[origin.length];
//        List<Integer> list = new ArrayList<>();
//        for(int num : origin) {
//            list.add(num);
//        }
//        Random random = new Random();
//        for (int i = 0; i < ans.length; i ++) {
//            int temp = random.nextInt(list.size());
//            ans[i] = list.remove(temp);
//        }
//
//        return ans;
    }
}
