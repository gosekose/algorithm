package gcd;

public class FindGcd {

    int findGCD(int[] arr) {
        int gcd = arr[0];
        for (int num : arr) {
            gcd = getGCD(gcd, num);
        }
        return gcd;
    }

    int getGCD(int x, int y) {
        if (y == 0) return x;
        return getGCD(y, x % y);
    }
}
