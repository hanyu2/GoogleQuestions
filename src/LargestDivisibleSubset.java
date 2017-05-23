import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		int[] parent = new int[nums.length];
		int[] count = new int[nums.length];
		int max = 0;
		int maxIndex = -1;
		Arrays.sort(nums);
		if (nums.length == 0) {
			return res;
		} else if (nums.length == 1) {
			res.add(nums[0]);
			return res;
		} else {
			for (int i = nums.length - 1; i >= 0; i--) {
				for (int j = i; j < nums.length; j++) {
					if (nums[j] % nums[i] == 0 && count[j] + 1 > count[i]) {
						count[i] = count[j] + 1;
						parent[i] = j;
						if (count[i] > max) {
							max = count[i];
							maxIndex = i;
						}
					}
				}
			}
		}
		for (int i = 0; i < max; i++) {
			res.add(nums[maxIndex]);
			maxIndex = parent[maxIndex];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 16, 8 };
		List<Integer> res = largestDivisibleSubset(nums);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
