package middle.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * No.969 煎饼排序
 */
public class No_969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int maxRange = arr.length;
        while (maxRange > 0) {
            int maxIdx = getMaxIdx(arr, maxRange);
            reverse(arr, maxIdx + 1);
            ans.add(maxIdx + 1);
            reverse(arr, maxRange);
            ans.add(maxRange);
            maxRange --;
        }
        return ans;
    }

    private void reverse(int[] arr, int right) { //[left, right]
        int left = 0;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right - 1];
            arr[right - 1] = temp;
            left ++;
            right --;
        }
    }

    private int getMaxIdx(int[] arr, int maxRange) {
        int maxIdx = 0;
        for (int i = 1; i < maxRange; i ++) {
            maxIdx = arr[maxIdx] > arr[i] ? maxIdx : i;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        No_969 test = new No_969();
        int[] arr = {3,2,1,4};
        List<Integer> ans = test.pancakeSort(arr);
        for (int i : ans) {
            System.out.println(i);
        }
        System.out.println("arr:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
