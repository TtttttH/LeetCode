package middle.Array;

import java.util.Random;

/**
 * No.215 数组中的第k个最大元素 (Microsoft)
 */
public class No_215 {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1, target = k - 1;
        while (true) {
            int pivot = randomPartition(nums, low, high);
            if (pivot == target) return nums[pivot];
            else if (pivot < target) low = pivot + 1;
            else high = pivot - 1;
        }
    }

    private int randomPartition(int[] nums, int low, int high) {
        if (low < high) {
            int randomIndex = rand.nextInt(high - low + 1) + low;
            swap(nums, low, randomIndex);
        }
        int index = low + 1;
        for (int i = index; i <= high; i++) {
            if (nums[i] > nums[low]) {
                swap(nums, i, index);
                index++;
            }
        }

        swap(nums, low, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
