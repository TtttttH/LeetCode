package middle.greedy;

/**
 * No.376 摆动序列
 */
public class No_376 {
    public int wiggleMaxLength (int[] nums) {
        int preDiff = 0;//前一个峰值
        int curDiff = 0;//当前峰值
        int res = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <=0) || (curDiff < 0 && preDiff >=0)) {
                res ++;
                preDiff = curDiff;
            }
        }

        return res;
    }
}
