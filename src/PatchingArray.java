
public class PatchingArray {
	static int minPatches(int[] nums, int n) {
	    int miss = 1, added = 0, i = 0;
	    while (miss <= n) {
	        if (i < nums.length&& nums[i] <= miss) {
	            miss += nums[i++];
	        } else {
	            miss += miss;
	            added++;
	        }
	    }
	    return added;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(minPatches(nums, 20));
	}
}
