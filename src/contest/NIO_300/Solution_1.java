package contest.NIO_300;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char ref = 'a';
        for (char ch : key.toCharArray()) {
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, ref);
                ref ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            sb.append(map.getOrDefault(ch, ' '));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        Solution_1 test = new Solution_1();
        System.out.println(test.decodeMessage(key, message));
    }
}
