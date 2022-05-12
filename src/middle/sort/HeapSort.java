package middle.sort;

/**
 * 堆排序
 */
public class HeapSort {

    public void heapSort(int[] arr) {
        buildHeap(arr);
        int len = arr.length - 1;
        for (int i = len; i > 0; i --) {
            swap(arr, 0, i);
            heapFy(arr, 0, i);
        }
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }

    private void buildHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i --) {
            heapFy(arr, i, len);
        }
    }
    private void heapFy(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < len && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < len && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            swap(arr, maxIdx, i);
            heapFy(arr, maxIdx, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4,0, 2, 1, 4, 5, 3, 8};
        HeapSort hs = new HeapSort();
        hs.heapSort(arr);

    }
}