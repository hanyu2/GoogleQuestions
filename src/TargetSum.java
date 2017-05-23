import java.util.HashMap;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return helper(nums, 0, 0, S, new HashMap<String, Integer>());
	}

	private int helper(int[] nums, int index, int sum, int S, HashMap<String,Integer> hashMap) {
		String encodeString = index + "->" + sum;
		if (hashMap.containsKey(encodeString)) {
			return hashMap.get(encodeString);
		}
		if (index == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		int curNum = nums[index];
		int add = helper(nums, index + 1, sum - curNum, S, hashMap);
		int minus = helper(nums, index + 1, sum + curNum, S, hashMap);
		hashMap.put(encodeString, add + minus);
		return add + minus;
	}
}
