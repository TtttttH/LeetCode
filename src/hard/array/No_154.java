package hard.array;

/**
 * No.154 寻找旋转数组中的最小值II (微软题)
 */
public class No_154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) { //说明[mid, right] 区间内都是顺序的, right 移动到mid处
                right = mid;
            } else if (nums[mid] > nums[right]) { //说明[mid, right]区间内出现了旋转index, left 移动到mid + 1处
                left = mid + 1;
            } else right --; //这里是相等情况，这时候[mid, right]区间内可能是连续相等可能是中间有旋转index，无法直接跳跃，只能将right--
        }
        return nums[left];
    }
}
