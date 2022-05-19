package contest.double76th;

public class No_1 {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        int temp = res;
        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs < temp) {
                res = num;
                temp = abs;
            } else if (abs == temp && num > res) {
                res = num;
            }
        }

        return res;
    }
}
