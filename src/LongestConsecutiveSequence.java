import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(int n : nums){
            if(map.containsKey(n)){
                continue;
            }
            int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
            int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
            int total = left + right + 1;
            max = Math.max(max, total);
            map.put(n, total);
            map.put(n - left, total);
            map.put(n + right, total);
        }
        return max;
    }
	public static void main(String[] args) {
		int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		System.out.println(longestConsecutive(nums));
	}
}
