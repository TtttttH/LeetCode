package easy;

/**
 * No.1360 日期之间间隔几天 (Microsoft)
 */
public class No_1360 {
    //关键思路:闰年定义为四年一闰，百年不闰，四百年再闰
    //由于题目只计算1971年之后的时间，所以可以以1971-1-1为基准时间计算，分别计算两个待比较日期对其的时间差求得结果
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysTo1971(date2) - daysTo1971(date1));
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int daysTo1971(String date) {
        int ans = 0;
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        for (int i = 1971; i < year; i ++) {
            ans += isLeapYear(i)? 366 : 365;
        }

        int[] monthday = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i ++) {
            if (i == 2 && isLeapYear(year)) ans += 29;
            else ans += monthday[i];
        }

        ans += day;

        return ans;
    }

    public static void main(String[] args) {
        String date1 = "2100-09-22";
        String date2 = "1991-03-12";
        No_1360 test = new No_1360();
        System.out.println(test.daysBetweenDates(date1, date2));
    }
}
