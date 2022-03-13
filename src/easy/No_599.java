package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.599 两个列表的最小索引总和
 */
public class No_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i ++) {
            map1.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i ++) {
            if (map1.containsKey(list2[i])) {
                int cur = i + map1.get(list2[i]);
                if (cur > minSum) continue;
                if (cur < minSum) list.clear();
                list.add(list2[i]);
                minSum = cur;
            }
        }

        String[] strs = new String[list.size()];
        for (int i = 0; i < strs.length; i ++) {
            strs[i] = list.get(i);
        }
        return strs;
    }
}
