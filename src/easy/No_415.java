package easy;

/**
 * No.415 字符串相加(Microsoft)
 */
public class No_415 {
    public String addStrings(String num1, String num2) {
        int addOne = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || addOne == 1) {
            int a = i >= 0? num1.charAt(i --) - '0' : 0;
            int b = j >= 0? num2.charAt(j --) - '0' : 0;
            int c = a + b + addOne;
            addOne = c / 10;
            c = c % 10;
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No_415 test = new No_415();
        System.out.println(test.addStrings("456", "77"));
    }
}
