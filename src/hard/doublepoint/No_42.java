package hard.doublepoint;

/**
 * No.42 接雨水 双指针解法O(n) O(1)
 * 整体思路，双指针维护左右最大边，左右中较小的最大边会决定当前节点的水位高度
 */
public class No_42 {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {//当前节点的左边为其较小边
                result += leftMax - height[left];
                left ++;
            } else {
                result += rightMax - height[right];
                right --;
            }
        }

        return result;
    }
}
