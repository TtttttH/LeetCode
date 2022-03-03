package SwordToOffer.easy;

/**
 * No.11 旋转数组的最小数字
 */
public class Offer_11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            } else right --;
        }

        return numbers[left];
//        for (int i = 1; i < numbers.length; i ++) {
//            if (numbers[i] < numbers[i - 1]) return numbers[i];
//        }
//        return numbers[0];
    }
}
