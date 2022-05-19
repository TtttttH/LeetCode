package hard.array;

/**
 * No.4 寻找两个正序数组的中位数(hard) Microsoft
 */
public class No_4 {
    /**
     * O(m+n)做法
     */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        int len = m + n;
        for (int i = 0; i <= len/2; i ++) {
            left = right;
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1 ++];
            } else {
                right = nums2[start2 ++];
            }
        }

        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * O(log(m + n) 写法
     * 二分法
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        if (len % 2 == 0) return (getKthMin(nums1, 0, nums2, 0, len / 2) + getKthMin(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        else return getKthMin(nums1, 0, nums2, 0, len / 2 + 1);
    }

    private double getKthMin(int[] nums1, int i , int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];

        if (k == 1) return Math.min(nums1[i], nums2[j]);

        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return getKthMin(nums1, i + k / 2, nums2, j, k - k / 2);
        } else return getKthMin(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}
