package com.company;

public class PrimeChecker {
    public static void main(String[] args) {
        int n = 1;
        while (n <= 25) {
            if (isPrime(n) == true) {
                System.out.println("The number " + n + " is a prime number");
        	} else {
                System.out.println("The number " + n + " is not a prime number");
            }
            n++;
        }
    }

    public static boolean isPrime(int n) {
		int num = 2;
		while (num <= (n - 1)) {
			if ((n % num) == 0) {
				return false;
			}
			num++;
		}
		return true;
	}
}
