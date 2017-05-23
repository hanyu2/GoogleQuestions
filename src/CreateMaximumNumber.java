
public class CreateMaximumNumber {
	// http://www.cnblogs.com/CarryPotMan/p/5384172.html
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] result = new int[k];
		if (len1 + len2 < k) {
			return result;// bad case
		} else if (len1 + len2 == k) {
			result = mergeTwoArrays(nums1, nums2, k);// edge case
		} else {
			for (int i = 0; i <= k; i++) {
				if (i <= len1 && (k - i) <= len2) {
					int[] maxNumbers1 = maxNumberOfSingleArray(nums1, i);
					int[] maxNumbers2 = maxNumberOfSingleArray(nums2, k - i);
					int[] maxNumbers = mergeTwoArrays(maxNumbers1, maxNumbers2, k);
					if (compareTwoArrays(maxNumbers, 0, result, 0))
						result = maxNumbers;
				}
			}
		}
		return result;
	}

	private static int[] mergeTwoArrays(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		int idx1 = 0, idx2 = 0;
		int idx = 0;
		while (idx < k) {
			// check the two remain arrays to see which one is larger.
			if (compareTwoArrays(nums1, idx1, nums2, idx2)) {
				result[idx] = nums1[idx1++];
			} else {
				result[idx] = nums2[idx2++];
			}
			idx++;
		}
		return result;
	}

	// get the largest k numbers when keeping the relative order
	private static int[] maxNumberOfSingleArray(int[] nums, int k) {
		int[] result = new int[k];
		if (k == 0)
			return result;

		int len = nums.length;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			while ((len - i - 1) + (idx + 1) > k && idx > 0 && nums[i] > result[idx - 1])
				idx--;
			if (idx < k)
				result[idx++] = nums[i];
		}
		return result;
	}

	// compare two arrays at the "start" index
	public static boolean compareTwoArrays(int[] nums1, int startIdx1, int[] nums2, int startIdx2) {
		int len1 = nums1.length - startIdx1;
		if (len1 <= 0)
			return false;
		int len2 = nums2.length - startIdx2;
		if (len2 <= 0)
			return true;
		int len = Math.max(len1, len2);
		for (int i = 0; i < len; i++) {
			int digit1 = startIdx1 + i < nums1.length ? nums1[startIdx1 + i] : 0;
			int digit2 = startIdx2 + i < nums2.length ? nums2[startIdx2 + i] : 0;
			if (digit1 != digit2) {
				return digit1 > digit2;
			}
		}
		return true;// equal, choose either one is ok
	}

	public static void main(String[] args) {
		int[] nums1 = { 3, 9 };
		int[] nums2 = { 8, 9 };
		int[] res = maxNumber(nums1, nums2, 3);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
/*
 * Easy compare failed test case: [2,5,6,4,4,0] [7,3,8,0,6,5,7,6,2] 15 Output:
 * [7,3,8,2,5,6,4,4,0,0,6,5,7,6,2] Expected: [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
 */