package middle.String;

/**
 * No.8 字符串转换整数(atoi)
 */
public class No_8 {
    public int myAtoi(String s) {
        boolean minus = false;
        char[] chars = s.toCharArray();
        int start = 0;
        int len = chars.length;
        //step1:去空格
        while (start < len && chars[start] == ' ') {
            start ++;
        }
        if (start == len) return 0; //空格去完已经到达终点

        //step2:判断符号
        if (chars[start] == '-') {
            minus = true;
            start ++;
        } else if (chars[start] == '+') {
            start ++;
        }

        //step3:开始计算，遇到非数字跳出循环，注意这里防止溢出
        int ans = 0;
        while (start < len && chars[start] >= '0' && chars[start] <= '9') {
            int digit = chars[start] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return minus? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            start ++;
        }

        return minus ? - ans : ans;
    }

    public static void main(String[] args) {
        String s = "words and 987";
        No_8 test = new No_8();
        System.out.println(test.myAtoi(s));
    }
}
