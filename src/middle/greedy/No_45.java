package middle.greedy;

/**
 * No.45 跳跃游戏II
 */
public class No_45 {

    public int jump(int[] nums) {
        int ans = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);
            if (i == curDistance) { // 说明curDistance < nums.length - 1
                ans ++;
                curDistance = nextDistance;
            }
        }
        return ans;
    }
}
