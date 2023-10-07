public class Loops {
    // 4.30
	public void multiplesOfFive() {
		int index = 10;
		while (index <= 95) {
			System.out.println(index);
			index = index + 5;
		}
	}

	// 4.31
	public void printSum() {
		int sum = 0;
		int num = 1;
		while (num <= 10) {
			sum = sum + num;
			num++;
		}
		System.out.println(sum);
	}

	// 4.32
	public void sum(int a, int b) {
		int sum = 0;
		int num = a;
		while (num <= b) {
			sum = sum + num;
			num++;
		}
		System.out.println(sum);
	}

	// 4.33
	public boolean isPrime(int n) {
		int num = 2;
		while (num <= (n - 1)) {
			if ((n % num) == 0) {
				return false;
			}
			num++;
		}

		if (n < 2) {
			return false;
		}
		return true;
	}
}
