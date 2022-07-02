package middle.doublepoint;

/**
 * No.1574 删除最短的子数组使剩余数组有序 (Microsoft)
 */
public class No_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 1, right = arr.length - 2;
        int res = 0;
        while (left < n && arr[left] >= arr[left - 1]) left ++;
        if (left == n) return 0;

        while (right >= 0 && arr[right + 1] >= arr[right]) right --;

        res = Math.min(n - left, right + 1);
        int j = right + 1;
        for (int i = 0; i < left && j < n; i ++) {
            while (j < n && arr[j] < arr[i]) {
                j ++;
            }

            res = Math.min(res, j - i - 1);
        }

        return res;
    }
}
