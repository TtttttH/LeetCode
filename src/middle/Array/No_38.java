package middle.Array;

/**
 * No.38 外观数列
 */
public class No_38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i ++) {
            int start = 0, pos = 0;
            StringBuilder sb = new StringBuilder();
            while (pos < s.length()) {
                while(pos < s.length() && s.charAt(pos) == s.charAt(start)) pos ++;
                sb.append(pos - start).append(s.charAt(start));
                start = pos;
            }
            s = sb.toString();
//            System.out.println(s);
        }

        return s;
    }

    public static void main(String[] args) {
        No_38 test = new No_38();
        test.countAndSay(4);
    }
}
