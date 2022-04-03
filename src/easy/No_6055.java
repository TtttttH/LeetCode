package easy;

/**
 * No.6055 转化时间需要的最少操作数
 */
public class No_6055 {
    public int convertTime(String current, String correct) {
        int hour = Integer.parseInt(correct.substring(0, 2)) - Integer.parseInt(current.substring(0, 2));
        int minutes = Integer.parseInt(correct.substring(3,5)) - Integer.parseInt(current.substring(3,5));
        if (minutes < 0) {
            minutes += 60;
            hour --;
        }
        int res = hour;
        res += minutes / 15;
        minutes %= 15;
        res += minutes / 5 + minutes % 5;
        return res;
    }

    public static void main(String[] args) {
        String cur = "09:41";
        String cor = "10:34";
        No_6055 test = new No_6055();
        System.out.println(test.convertTime(cur, cor));
    }
}
