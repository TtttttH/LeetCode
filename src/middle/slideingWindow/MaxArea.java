package middle.slideingWindow;

/**
 * No.11 盛水最多的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        if (null == height || height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        int area = 0;
        while(i < j) {
            area = Math.min(height[i], height[j])  * (j - i);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i ++;
            } else {
                j --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        MaxArea ma = new MaxArea();
        System.out.printf("maxArea: " + ma.maxArea(heights));
    }
}
