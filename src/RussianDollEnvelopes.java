import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
			return 0;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[1] == arr2[1])
					return arr2[0] - arr1[0];
				else
					return arr1[1] - arr2[1];
			}
		});
		int dp[] = new int[envelopes.length];
		int len = 0;
		for (int[] envelope : envelopes) {
			int index = Arrays.binarySearch(dp, 0, len, envelope[0]);
			if (index < 0)
				index = -(index + 1);
			dp[index] = envelope[0];
			if (index == len)
				len++;
		}
		return len;
	}

	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int[] nums = {0, 1, 2, 3, 5};
		System.out.println(Arrays.binarySearch(nums, 0, nums.length, 4));
		System.out.println(maxEnvelopes(envelopes));
	}
}
