package swap;

public class Swap {

    static int m = 5;
    static int[] tmp = new int[6];
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};

        swap(arr, 3, 1);

        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    static void swap(int[] arr, int k, int clockWise) { // k 만큼 스왑
        if(clockWise == 0) {    // 시계 방향 회전
            for (int i = 1; i <= m; i++) {
                int next = i + k > m ? i + k - m : i + k;
                tmp[next] = arr[i];
            }
        }
        else {    // 반시계 방향 회전
            for (int i = m; i >= 1; i--) {
                int next = i - k > 0 ? i - k : i - k + m;
                tmp[next] = arr[i];
            }
        }

        System.arraycopy(tmp, 1, arr, 1, arr.length - 1);
    }

}
