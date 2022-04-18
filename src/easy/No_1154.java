package easy;

/**
 * No.1154 一年中的第几天 (Microsoft)
 */
public class No_1154 {
    /**
     *
     * @param date 2019-01-09
     * @return
     */
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            amount[1] ++;
        }

        int res = 0;
        for (int i = 1; i < month; i ++) {
            res += amount[i - 1];
        }

        res += day;
        return res;
    }

    public static void main(String[] args) {
        No_1154 test = new No_1154();
        String date = "2019-03-08";
        System.out.println(test.dayOfYear(date));
    }
}
