import java.util.Stack;

public class NextGreaterElement2 {
	public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < nums.length * 2; i++){
            if(stack.isEmpty()){
                stack.push(i % n);
            }else{
                while(!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]){
                    res[stack.pop() % n] = nums[i % n];
                }
                if(i < n){
                	stack.push(i % n);
                }
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop() % n] = -1;
        }
        return res;
    }
	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		int[] res = nextGreaterElements(nums);
	}
}
