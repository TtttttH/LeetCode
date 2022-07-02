package easy.monotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.1051 高度检查器
 */
public class No_1051 {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        if (len == 1) return len;
        int[] counts = new int[101];
        for (int height : heights) {
            counts[height] ++;
        }

        int idx = 0;
        for (int i = 1; i < 101; i ++) {
            for (int j = 0; j < counts[i]; j ++) {
                if (heights[idx ++] == i) len --;
            }
        }

        return len;
    }
}
