import java.util.Stack;

//388
public class LongestAbsoluteFilePath {
	public static int lengthLongestPath(String input) {
		if(input == null || input.length() == 0 || input.indexOf('.') == -1){//test case "a"
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
		String[] strs = input.split("\n");
		for(int i = 0; i < strs.length; i++){
			String s = strs[i];
			int t = 0;
			while(s.startsWith("\t")){
				s = s.substring(1);
 				t++;
			}
			int len = 0;
			if(t == stack.size()){
				if(!stack.isEmpty()){
					len = stack.peek() + s.length();//1.check stack empty
				}else{
					len = s.length();
				}
				stack.push(len + 1);
			}else if(t == stack.size() - 1){
				stack.pop();
				if(stack.isEmpty()){
					stack.push(s.length() + 1);
				}else{
					stack.push(stack.peek() + s.length() + 1);
				}
			}else{//3.check stack empty "a\n\tb.txt\na2\n\tb2.txt"
				while(t <= stack.size() - 1){
					stack.pop();
				}
				if(stack.isEmpty()){
					stack.push(s.length() + 1);
				}else{
					stack.push(stack.peek() + s.length() + 1);
				}
			}
			if(s.indexOf('.') != -1){
				maxLen = Math.max(stack.peek(), maxLen);
			}
		}
		return maxLen - 1;
	}
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		String input2 = "a\n\tb.txt\na2\n\tb2.txt";
		String input3 = "a";
		String input4 = "rzzmf\nv\n\tix\n\t\tiklav\n\t\t\ttqse\n\t\t\t\ttppzf\n\t\t\t\t\tzav\n\t\t\t\t\t\tkktei\n\t\t\t\t\t\t\thhmav\n\t\t\t\t\t\t\t\tbzvwf.txt";
		String input5 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lengthLongestPath(input5));
	}
}
/*
 * First: Forget to ckeck stack empty when trying to peek from stack
 * Second: for case that two directories on the same level, we don't have
 * to check the equality of length of this level and the level of the upoper level
 * a
 * 	aaaaaa
 *    x.txt
 *  a
 *    xxxxxxxxxx.txt
 * 
 * 
 * */
