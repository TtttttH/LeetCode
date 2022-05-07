package middle.sort;

/**
 * 计数排序
 */
public class CountingSort {
    public static void sort(int[] arr) {
        int min = arr[0], max = min;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] bucket = new int[max - min + 1];
        for (int num : arr) {
            bucket[num - min] ++;
        }

        int n = 0;
        for(int i = 0; i < arr.length; i ++) {
            while (bucket[n] == 0) n ++;
            arr[i] = n;
            bucket[n] --;
        }

        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4,0, 2, 1, 4, 5, 3, 8};
        CountingSort.sort(arr);
    }
}
