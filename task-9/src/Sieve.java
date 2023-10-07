import java.util.Arrays;
import java.lang.Math;
/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author William Berg
 * @version 2019-11-13
 */
public class Sieve {
    private static final int max = (int)(Math.pow(2, 26));
    boolean[] primeCache;

    public static void main(String[] args) {
    }

    public Sieve() {
        primeCache = new boolean[0];
    }

    /**
     * Check if a number is prime or not!
     * <p>
     * Note that prime[n] denotes the primality of number n.
     *
     * @param number An integer value to be checked for primality.
     * @return true if number is prime, false otherwise.
     */
    // S.4, S.5
    public boolean isPrime(int number) {
        exceptionIfIllegalArg(number);
        boolean[] prime = sieve(number); // sieve(number) is a boolean array with size number+1
        if (number>=primeCache.length) {
            primeCache = prime; // elements of prime array copied into primeCache array
            return prime[number]; // boolean value for number in prime array
        } else {
            return primeCache[number]; // boolean value for number in primeCache array
        }
    }

    /**
     * Check if a number is out of bounds (error handling).
     * @param number An integer value to be checked if it is out of bounds.
     */
    // S.4
    private void exceptionIfIllegalArg(int number) {
        if (number < 2) {
            throw new IllegalArgumentException("number is too small");
        }
        if (number > max) {
            throw new IllegalArgumentException("number is too big");
        }
    }

    /**
     * Compute primality.
     * @param number An integer value to be checked for primality.
     * @return Boolean array.
     */
    // S.4
    private boolean[] sieve(int number) {
        boolean[] prime = new boolean[number+1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // assume all numbers are prime
        int sqrt = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = false; // mark multiples of i as not prime
                }
            }
        }
        return prime;
    }
}
