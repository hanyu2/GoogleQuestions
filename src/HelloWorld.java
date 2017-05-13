import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("aabaa"));
	}

	public static int longestPalindromeSubseq(String s) {
		if (s == null) {
			return -1;
		}
		if (s.length() <= 1) {
			return s.length();
		}
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		int max = 1;
		for (int j = 1; j < len; j++) {
			for (int t = 0; t < len - j; t++) {
				if (s.charAt(t) == s.charAt(t + j)) {
					if (t + 1 > t + j - 1) {
						dp[t][t + j] = 2;
					} else {
						dp[t][t + j] = dp[t + 1][t + j - 1] + 2;
					}
				} else {
					dp[t][t + j] = Math.max(dp[t + 1][t + j], dp[t][t + j - 1]);
				}
				max = Math.max(dp[t][t + j], max);
			}
		}
		return max;
	}
}
