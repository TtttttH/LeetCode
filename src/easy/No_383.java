package easy;

/**
 * No.383 赎金信
 */
public class No_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] maga = new int[26];
        for (Character c: magazine.toCharArray()) {
            maga[c - 'a'] ++;
        }

        for (Character c: ransomNote.toCharArray()) {
            if (maga[c - 'a'] > 0) {
                maga[c - 'a'] --;
            } else {
                return false;
            }
        }
        return true;
//        int[] ransom = new int[26];
//        int[] maga = new int[26];
//        for (Character c: ransomNote.toCharArray()) {
//            ransom[c - 'a'] ++;
//        }
//
//        for (Character c: magazine.toCharArray()) {
//            maga[c - 'a'] ++;
//        }
//
//        for (Character c: ransomNote.toCharArray()) {
//            if (ransom[c - 'a'] > maga[c - 'a']) {
//                return false;
//            }
//        }
//
//        return true;
    }
}
