package prime;

import java.util.ArrayList;
import java.util.List;

public class FindPrime {

    List<Integer> primes = new ArrayList<>();

    void getPrime(int n) {
        int[] arr = new int[n + 1];
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= root; i++) {
            if (arr[i] != 0) {
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = 0;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                primes.add(arr[i]);
            }
        }
    }

}
