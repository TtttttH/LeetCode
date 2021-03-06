package easy;

/**
 * No.88 合并两个有序数组
 */
public class No_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = (m--) + (n--) - 1;

        while (m >= 0 && n >= 0) {
            nums1[last--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[last --] = nums2[n --];
        }
    }
}
