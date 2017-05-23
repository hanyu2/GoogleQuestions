
public class RepeatedSubstringPattern {
	public static boolean repeatedSubstringPattern(String s) {
		for(int i = 1; i <= s.length() / 2; i++){
			if(s.length() % i == 0){
				String sub = s.substring(0, i);
				String temp = s;
				temp = temp.replace(sub, "");
				if(temp.length() == 0){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
	}
}
