package mergesort;

public class MergeSort {
    static int[] buff;

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            mergeSort(arr, left, right);
            mergeSort(arr, center + 1, right);

            for (i = left; i <= center; i++) buff[p++] = arr[i];

            while (i <= right && j < p) arr[k++] = (buff[j] <= arr[i]) ? buff[j++] : arr[i++];

            while (j < p) arr[k++] = buff[j++];
        }
    }
}
