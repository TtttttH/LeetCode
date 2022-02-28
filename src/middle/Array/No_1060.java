package middle.Array;

/**
 * No.1060 Missing Element in Sorted Array (Microsoft question)
 */
public class No_1060 {
    public int missingElement(int[] nums, int k) {
        if (nums.length == 1) return nums[0] + k;
        int right = nums.length - 1;
        int left = 0;
        int count = nums[right] - nums[left] - (right - left);
        if (count < k) return nums[right] + (k - count);
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            count = nums[mid] - nums[left] - (mid - left);
            if (count < k) {
                k -= count;
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] + k;
    }
}
