package contest.double77;

public class No_6052 {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) return 0;
        long total = 0;
        for (int num : nums) total += num;
        long min = Long.MAX_VALUE;
        int resIdx = -1;
        long left = 0;
        long right = total;
        for (int i = 0; i < n; i ++) {
            left += nums[i];
            right -= nums[i];
            long avgLeft = left / (i + 1);
            long avgRight = (i == n - 1)? 0 : right / (n - i - 1);
            long del = Math.abs(avgLeft - avgRight);
            if (min > del) {
                resIdx = i;
                min = del;
            }
        }

        return resIdx;
    }
}
