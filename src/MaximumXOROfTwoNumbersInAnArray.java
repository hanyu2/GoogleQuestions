
public class MaximumXOROfTwoNumbersInAnArray {
	class Trie {
		Trie[] children = new Trie[2];
	}

	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Trie root = new Trie();
		for (int num : nums) {
			Trie node = root;
			for (int i = 31; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (node.children[bit] == null) {
					node.children[bit] = new Trie();
				}
				node = node.children[bit];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			Trie node = root;
			int curSum = 0;
			for (int i = 31; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (node.children[bit ^ 1] != null) {
					node = node.children[bit ^ 1];
					curSum += (1 << i);
				} else {
					node = node.children[bit];
				}
			}
			max = Math.max(max, curSum);
		}
		return max;
	}
}
