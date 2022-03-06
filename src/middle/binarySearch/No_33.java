package middle.binarySearch;

/**
 * No.33 搜索旋转排序数组 (微软题) 要求O(log n)
 */
public class No_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) { //[mid, right] 为递增区间
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { //旋转节点在mid 和 right之间,此时[left, mid]为递增区间
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
