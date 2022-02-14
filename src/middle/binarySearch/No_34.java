package middle.binarySearch;

/**
 * No.34 在排序数组中查找元素的第一个和最后一个位置
 */
public class No_34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int leftIndex = leftBinarySearch(nums, target);
        int rightIndex = rightBinarySearch(nums, target);
        if (leftIndex == -2 || rightIndex == -2) {
            return new int[] {-1, -1};
        }

        if (rightIndex - leftIndex > 1) {
            return new int[] {leftIndex + 1, rightIndex - 1};
        }

        return new int[] {-1, -1};
    }

    private int rightBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = left;
            }
        }
        return ans;
    }

    private int leftBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7,8,8, 10};
        int target = 8;

        No_34 test = new No_34();
        test.searchRange(nums, target);
    }
}
