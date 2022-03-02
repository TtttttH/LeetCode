package easy;

/**
 * No.852 山脉数组的封顶索引 (No.153变种)
 */
public class No_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if (arr[mid] < arr[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
