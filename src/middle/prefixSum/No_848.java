package middle.prefixSum;

/**
 * No.848 字母移位(Microsoft)
 */
public class No_848 {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length() - 1;
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = n; i >= 0; i --) {
            cnt += shifts[i] % 26;
            chars[i] = (char) ((chars[i] - 'a' + cnt) % 26 + 'a');
        }

        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String s = "ruu";
        int[] shifts = {26, 9, 17};

        System.out.println(No_848.shiftingLetters(s, shifts));
    }
}
