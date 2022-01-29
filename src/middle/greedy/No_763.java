package middle.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * No.763 Partition Labels
 */
public class No_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> rangeMap = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            rangeMap.put(s.charAt(i), i);
        }

        int maxRange = rangeMap.get(s.charAt(0));
        int preRange = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (i == maxRange) {
                result.add(maxRange - preRange + 1);
                preRange = maxRange + 1;
            } else {
                maxRange = Math.max(rangeMap.get(s.charAt(i)), maxRange);
            }
        }

        return result;
    }
}
