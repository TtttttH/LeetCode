package middle.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1570 两个稀疏向量的点积
 */
public class No_1570 {

    class SparseVector {
        Map<Integer, Integer> map;
        SparseVector(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] != 0) map.put(i, nums[i]);
            }
        }

        public int dotProduct(SparseVector vec) {
            int res = 0;
            Map<Integer, Integer> vecMap = vec.map;
            Map<Integer, Integer> m1, m2;
            if (map.size() < vecMap.size()) {
                m1 = map;
                m2 = vecMap;
            } else {
                m1 = vecMap;
                m2 = map;
            }
            for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
                res += entry.getValue() * m2.getOrDefault(entry.getKey(), 0);
            }

            return res;
        }
    }
}