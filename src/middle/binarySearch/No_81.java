package middle.binarySearch;

/**
 * No.81 搜索旋转排序数组II
 */
public class No_81 {
    //相比于No.33增加了重复元素的情况，多一个移动条件
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) { //[mid, right]上有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { //遇到重复数字
                right --;
            }
        }

        return false;
    }
}
