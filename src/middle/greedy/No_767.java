package middle.greedy;

import java.util.PriorityQueue;

/**
 * No.767 重构字符串 (Microsoft)
 */
public class No_767 {
    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] counts = new int[26];
        PriorityQueue<Pair> maxQueue = new PriorityQueue<>(((o1, o2) -> o2.count - o1.count));
        for (char ch : chars) {
            counts[ch - 'a'] ++;
        }

        for (int i = 0; i < 26; i ++) {
            if (counts[i] > (n + 1) / 2) return "";
            else {
                maxQueue.add(new Pair((char) (i+'a'), counts[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(maxQueue.peek().count != 0) {
            Pair first = maxQueue.poll();
            Pair second = maxQueue.poll();
            if (second.count > 0) {
                sb.append(first.ch).append(second.ch);
                first.count --;
                second.count --;
            } else {
                sb.append(first.ch);
                return sb.toString();
            }

            maxQueue.add(first);
            maxQueue.add(second);
        }

        return sb.toString();
    }

    private class Pair{
        int count;
        char ch;
        Pair (char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        String s = "aaab";
        No_767 test = new No_767();
        System.out.println(test.reorganizeString(s));
    }
}
