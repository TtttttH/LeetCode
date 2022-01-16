package easy;

/**
 * No.58 最后一个单词的长度
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) != ' ') {
                result ++;
            } else if (result != 0){
                break;
            }
        }

        return result;
    }
}
