package quicksort;

// nlogn 시간 복잡도
public class QuickSort {

    static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int p = arr[(left + right) / 2];

        do {
            while(arr[pl] < p) pl++;
            while(arr[pr] > p) pr--;

            if (pl <= pr) swap(arr, left, right);
        } while(pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }
}
