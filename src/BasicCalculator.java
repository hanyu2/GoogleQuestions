import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<Integer>();
        if(s.length() == 0){
            return 0;
        }
        s = "(" + s + ")";
        int sign = 1;
        int sum = 0;
        int num = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
            	stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }else if(c == '-'){
            	sum += num * sign;
            	num = 0;
                sign = -1;
            }else if(c == '+'){
            	sum += num * sign;
            	num = 0;
            	sign = 1;
            }else if(c == ')'){
            	sum += num * sign;
            	sum *= stack.pop();
            	sum = sum + stack.pop();
            	num = 0;
            }else if(Character.isDigit(c)){
            	num = num * 10 + (int)(c - '0');
            }
        }
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(calculate("1 - 2 - (3 - 4 + (5-6))"));
	}
}
