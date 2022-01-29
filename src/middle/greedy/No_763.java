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
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            edge[chars[i] - 'a'] = i;
        }

        int minEdge = 0;
        int lastEdge = -1;
        for (int i = 0; i < chars.length; i ++) {
            minEdge = Math.max(minEdge, edge[chars[i] - 'a']);
            if (i == minEdge) {
                result.add(minEdge - lastEdge);
                lastEdge = minEdge;
            }
        }

        return result;
    }
}
