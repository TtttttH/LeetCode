package middle.slideingWindow;

/**
 * No.904 水果成篮
 */
public class TotleFruit_904 {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length ==0) {
            return 0;
        }

        int len = fruits.length;
        if (len <= 2) {
            return len;
        }

        int res = 2;
        int first = 0;
        int second = 0;
        int temp = 0;
        for (int i = 0; i < len; i ++) {
            if (fruits[i] == fruits[first] || fruits[i] == fruits[second]) {
                if (fruits[first] != fruits[second]) {
                    first = temp;
                    second = i;
                } else {
                    second = i;
                }

                temp = second;
                res = Math.max(res, i - first + 1);
            }
        }
        return res;
//
//        int res = 2;
//        int left = 0;
//        int right = 1;
//        int leftNum = fruits[left];
//        int rightNum = fruits[right];
//        while(right < len) {
//            if (fruits[right] == leftNum || fruits[right] == rightNum) {
//                res = Math.max(res, right - left + 1);
//                right ++;
//            } else { // 遇到第三种树,直接将left移动到right前一位，再向左遍历
//                left = right - 1;
//                leftNum = fruits[left];
//                rightNum = fruits[right];
//                while (fruits[left] == leftNum || fruits[left] == rightNum) {
//                    left --;
//                }
//                res = Math.max(res, right - left);
//                left ++;
//                right ++;
//            }
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
        TotleFruit_904 tf = new TotleFruit_904();
        System.out.println(tf.totalFruit(nums));
    }
}
