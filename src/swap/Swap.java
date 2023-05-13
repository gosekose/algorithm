package swap;

public class Swap {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr1R = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 1, 2, 3, 4, 5};
        int[] arr2R = {0, 1, 2, 3, 4, 5};

        swap(arr1, 1);
        for (int i : arr1) {
            System.out.println("i = " + i);
        }

        System.out.println();
        swapR(arr1R, 1);
        for (int i : arr1R) {
            System.out.println("i = " + i);
        }

        System.out.println();
        swap(arr2, 1, 1, arr2.length);
        for (int i : arr2) {
            System.out.println("i = " + i);
        }

        System.out.println();
        swapR(arr2R, 1, 1, arr2R.length);
        for (int i : arr2R) {
            System.out.println("i = " + i);
        }
    }

    static void swap(int[] arr, int k) { // k칸만큼 밀기
        int n = arr.length;
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[(i + k) % n] = arr[i];
        }

        System.arraycopy(tmp, 0, arr, 0, n);

    }

    // n = 5, k = 1
    static void swapR(int[] arr, int k) { // k칸만큼 밀기 // 2 3 4 5 1
        int n = arr.length;
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[(i + n - k) % n] = arr[i];
        }

        System.arraycopy(tmp, 0, arr, 0, n);
    }

    static void swap(int[] arr, int k, int start, int end) {
        int[] tmp = new int[end - start];

        for (int i = start; i < end; i++) { // start = 1, end = 6, i = 1, k = 3
            tmp[(i - start + k) % (end - start)] = arr[i];
        }

        System.arraycopy(tmp, 0, arr, start, end - start);
    }


    static void swapR(int[] arr, int k, int start, int end) {
        int[] tmp = new int[end - start];
        int len = end - start;

        for (int i = start; i < end; i++) {
            tmp[(i - start + len - k) % len] = arr[i];
        }

        System.arraycopy(tmp, 0, arr, start, len);
    }

}
