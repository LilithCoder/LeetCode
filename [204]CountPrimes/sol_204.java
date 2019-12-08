package LeetCode;

public class sol_204 {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        int primeCount = 0;
        // do not count i = 0/1
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
