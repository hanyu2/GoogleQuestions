import java.util.HashMap;
import java.util.Map;

/*I think if there are negative numbers in the array, 
 * we must add a requirement that each number is only used one time, 
 * or either positive number or negative number should be used only one time, 
 * otherwise there would be infinite possible combinations.
*/
public class CombinationSum4 {
	static Map<Integer, Integer> map = new HashMap<>();

	public static int combinationSum4(int[] nums, int target) {
		int count = 0;
		if (nums == null || nums.length == 0 || target < 0)
			return 0;
		if (target == 0)
			return 1;
		if (map.containsKey(target))
			return map.get(target);
		for (int num : nums) {
			count += combinationSum4(nums, target - num);
		}
		map.put(target, count);
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(combinationSum4(nums, 4));
	}
}
