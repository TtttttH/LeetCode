package middle.sort;

/**
 * 快速排序 O(n logn)
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }


    private void qsort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = partition(arr, low, high);
        qsort(arr, pivot + 1, high);
        qsort(arr, low, pivot - 1);
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //将arr[low] 设为基准
        while (low < high) {
            while (low < high && arr[high] >= pivot) high --;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low ++;
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;
    }
}
