package easy;

public class No_744 {
    public char nextGreatestLetter(char[] letters, char target) {
//      O(n)
//        for (char letter : letters) {
//            if (letter - target > 0) return letter;
//        }
//
//        return letters[0];

        //由于数组排序过，可以二分
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid;
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
