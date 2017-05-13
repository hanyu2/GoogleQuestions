import java.util.Stack;

public class TrappingRainWater {
	public static int trap(int[] height) {
        int i = 0;
        int total = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i < height.length){
            if(stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
            }else{
                int bottom = height[stack.pop()];
                int water = stack.isEmpty() ? 0 : ((Math.min(height[stack.peek()], height[i]) - bottom) * (i - stack.peek() - 1));
                total += water;
            }
        }
        return total;
    }
	public static void main(String[] args) {
		int[] height = {2, 0, 2};
		System.out.println(trap(height));
	}
}
