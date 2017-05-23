public class MaxSumOfRectangleNoLargerThanK {
	public static int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;

		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int left = j - 1 < 0 ? 0 : sum[i][j - 1];
				int up = i - 1 < 0 ? 0 : sum[i - 1][j];
				int leftUp = 0;
				if (i - 1 >= 0 && j - 1 >= 0) {
					leftUp = sum[i - 1][j - 1];
				}
				sum[i][j] = left + up + matrix[i][j] - leftUp;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int r = 0; r <= i; r++) {
					for (int c = 0; c <= j; c++) {
						int s = sum[i][j];
						int left = c - 1 < 0 ? 0 : sum[i][c - 1];
						int up = r - 1 < 0 ? 0 : sum[r - 1][j];
						int leftUp = 0;
						if (r - 1 >= 0 && c - 1 >= 0) {
							leftUp = sum[r - 1][c - 1];
						}
						s = s - left - up + leftUp;
						if (s <= k) {
							max = Math.max(s, max);
						}
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 2, -1 } };
		System.out.println(maxSumSubmatrix(matrix, 3));
	}
}
