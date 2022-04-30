package middle.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1497 检查数组对是否可以被k整除 (Microsoft)
 */
public class No_1497 {
    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCnt = new HashMap<>();
        for (int num : arr) {
            int remain = (num % k + k) % k; // 题中数组有负数存在,为了让负数余数也落在[0,k)中,故做此操作
            remainderCnt.put(remain, remainderCnt.getOrDefault(remain, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : remainderCnt.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int left = remainderCnt.getOrDefault(k - key, 0);
            if (key > 0 && val != left) return false;
        }

        return remainderCnt.getOrDefault(0, 0) % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        System.out.println(No_1497.canArrange(arr, 5));
    }
}
