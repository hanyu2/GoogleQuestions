import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	class Node {
		Node left, right;
		int val, sum, dup = 1;

		public Node(int v, int s) {
			val = v;
			sum = s;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums.length == 0) {
			return list;
		}
		Node root = new Node(nums[nums.length - 1], 1);
		list.add(0);
		for (int i = nums.length - 2; i >= 0; i--) {
			int num = insert(root, nums[i]);
			list.add(0, num);
		}
		return list;
	}

	public int insert(Node root, int n) {
		int count = 0;
		while (true) {
			if (n <= root.val) {
				root.sum++;
				if (root.left == null) {
					root.left = new Node(n, 1);
					break;
				} else {
					root = root.left;
				}
			} else {
				count += root.sum;
				if (root.right == null) {
					root.right = new Node(n, 1);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return count;
	}

	public List<Integer> countSmaller2(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		List<Integer> sorted = new ArrayList<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = search(sorted, nums[i]);
			ans[i] = index;
			sorted.add(index, nums[i]);
		}
		return Arrays.asList(ans);
	}

	public int search(List<Integer> sorted, int n) {
		int start = 0, end = sorted.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (sorted.get(mid) < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
		CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
		List list = c.countSmaller(nums);
	}
}
