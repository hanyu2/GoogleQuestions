
public class LongestIncreasingPathInAMatrix {
	static int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] mem = new int[row][col];
		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int length = search(matrix, i, j, mem, 1);
				max = Math.max(max, length);
			}
		}
		return max;
	}

	public static int search(int[][] matrix, int i, int j, int[][] mem, int len) {
		if (mem[i][j] != 0) {
			return mem[i][j];
		}
		int maxLen = 1;
		for (int[] dis : distance) {
			int x = i + dis[0];
			int y = j + dis[1];
			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
				if (matrix[x][y] > matrix[i][j]) {
					int l = 1 + search(matrix, x, y, mem, len + 1);
					maxLen = Math.max(l, maxLen);
				}
			}
		}
		mem[i][j] = maxLen;
		return maxLen;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 13, 5, 13, 9 }, { 5, 0, 2, 9 }, { 10, 13, 11, 10 }, { 0, 0, 13, 13 } };
		System.out.println(longestIncreasingPath(matrix));
	}
}
