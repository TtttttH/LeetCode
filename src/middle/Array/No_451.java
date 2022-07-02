package middle.Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * No.451 根据字符出现频率排序 (Microsoft)
 */
public class No_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map  = new HashMap<>();
        int maxFreq = 0;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }


        StringBuffer[] bucket = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i ++) {
            bucket[i] = new StringBuffer();
        }
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].append(entry.getKey());
        }

        for (int i = maxFreq; i > 0; i --) {
            for (char ch : bucket[i].toString().toCharArray()) {
                for (int k = 0; k < i; k ++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
