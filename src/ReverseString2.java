
public class ReverseString2 {
	public static String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		while (s.length() > 0) {
			StringBuilder temp = new StringBuilder(s.substring(0, Math.min(k, s.length())));
			if (!flag) {
				sb.append(temp.reverse());
				flag = true;
			} else {
				sb.append(temp);
				flag = false;
			}
			s = s.length() >= k ? s.substring(k) : "";
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}
}
