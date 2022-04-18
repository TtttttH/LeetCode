package middle.sort;

/**
 * 插入排序
 * time complexity: O(n^2)
 * space complexity: O(1)
 * 稳定
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j --) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4,0, 2, 1, 4, 5, 3, 8};
        InsertSort.insertSort(arr);
    }
}
