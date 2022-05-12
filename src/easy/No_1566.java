package easy;

/**
 * No.1566 重复至少K次且长度为M的模式 (Microsoft)
 */
public class No_1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i < n - k * m; i ++) {
            int j;
            for (j = i + m; j < i + k * m; j ++) {
                if (arr[j] != arr[j - m]) break;
            }

            if (j == i + k * m) return true;
        }

        return false;
    }
}
