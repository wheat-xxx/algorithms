package algorithms_04;

import java.util.Arrays;

/**
 * @author wheat
 * @date 2023/12/19  14:46
 */
public class Solution_204 {

    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public int countPrimes_2(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i = 2; i < n; ++i) {
            if(isPrime[i]) {
                if(isPrime(i)) {
                    count++;
                    for (long j = (long)i*i; j < n; j *= i) {
                        isPrime[(int)j] = false;
                    }
                } else {
                    for (int j = 1; j * i < n; j++) {
                        isPrime[j*i] = false;
                    }
                }
            }
        }
        return count;
    }

    public int countPrimes_3(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrimes[i]) {
                count++;
                for(long j = (long)i * i; j < n; j += i) {    // i * (i - 1)、i * (i - 2)... 已经被标记过了
                    isPrimes[(int)j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution_204().countPrimes_2(499979);
    }

}
