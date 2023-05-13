package swap;

public class Swap {

    static int[] tmp2 = new int[6];
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 1, 2, 3, 4, 5};

        swap(arr1, 1);
        for (int i : arr1) {
            System.out.println("i = " + i);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) arr1[i] = i + 1;
        swapR(arr1, 1);
        for (int i : arr1) {
            System.out.println("i = " + i);
        }

        System.out.println();
        swap(arr2, 2, 1, arr2.length);
        for (int i : arr2) {
            System.out.println("i = " + i);
        }

        System.out.println();
        for (int i = 0; i < 6; i++) arr2[i] = i;
        swapR(arr2, 1, 1, arr2.length);
        for (int i : arr2) {
            System.out.println("i = " + i);
        }

        System.out.println();
        for (int i = 0; i < 6; i++) arr2[i] = i;
        swap(arr2, 2, false);
        for (int i : arr2) {
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

    static void swap(int[] arr, int k, boolean clockWise) { // k 만큼 스왑
        int len = arr.length;

        if (clockWise) {
            for (int i = 1; i < len; i++) tmp2[(i - 1 + k) % (len - 1)] = arr[i];
        } else {
            for (int i = 1; i < len; i++) tmp2[(i - 1 + len - k) % (len - 1)] = arr[i];
        }

        System.arraycopy(tmp2, 0, arr, 1, len - 1);
    }

}
