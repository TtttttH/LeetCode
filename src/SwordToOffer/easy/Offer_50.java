package SwordToOffer.easy;

public class Offer_50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a'] ++;
        }

        for (char ch : s.toCharArray()) {
            if (counts[ch - 'a'] == 1) return ch;
        }

        return ' ';
    }
}
