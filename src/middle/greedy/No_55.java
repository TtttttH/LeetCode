package middle.greedy;

/**
 * No.55 跳跃游戏
 */
public class No_55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i ++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }


// My approach
//    public boolean canJump(int[] nums) {
//        int targetIdx = nums.length - 1;
//        for (int i = nums.length - 2; i >= 0; i --){
//            if (nums[i] >= targetIdx - i) {
//                targetIdx = i;
//            }
//        }
//        return targetIdx == 0 ;
//    }
}
