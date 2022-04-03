package middle.binarySearch;

import java.util.Arrays;

public class No_5219 {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k) return 0;
        long left = 1, right = sum;
        long max = 0;
        while (left <= right) {
            long mid = (left + (right - left) / 2);
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;
            }
            if (cnt >= k) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int)max;
    }
}
