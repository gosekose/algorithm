package prime;

public class FindPrime {

    static boolean[] getPrime(int n) {
        boolean[] notPrime = new boolean[n + 1];

        notPrime[0] = notPrime[1] = true;
        if (n == 1) return notPrime;

        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    notPrime[j] = true;
            }
        }

        return notPrime;
    }

    public static void main(String[] args) {
        boolean[] prime = getPrime(10);
        for (boolean b : prime) {
            System.out.println("b = " + b);
        }
    }
}
