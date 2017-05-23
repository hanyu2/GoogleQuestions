public class SuperUglyNumber {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] index = new int[primes.length];
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				min = Math.min(res[index[j]] * primes[j], min);
			}
			res[i] = min;
			for (int j = 0; j < primes.length; j++) {
				if (min % primes[j] == 0) {
					index[j]++;
				}
			}
		}
		return res[n - 1];
	}

	public static void main(String[] args) {
		int[] primes = { 2, 7, 13, 19 };
		System.out.println(nthSuperUglyNumber(12, primes));
	}
}
