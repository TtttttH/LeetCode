package easy;

/**
 * No.67 二进制求和
 */
public class No_67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int add = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int numa = i < 0 ? 0 : a.charAt(i--) - '0';
            int numb = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = numa + numb + add;
            if (sum>= 2) {
                add = 1;
            } else {
                add = 0;
            }
            result.append((sum) % 2);
        }

        if (add == 1) {
            result.append(add);
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        No_67 test = new No_67();
        System.out.println(test.addBinary(a, b));
    }
}
