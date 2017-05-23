import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetter {
	public static String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		boolean[] visited = new boolean[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		int index;
		for (char c : s.toCharArray()) {
			index = c - 'a';
			count[index]--;
			if (visited[index]) {
				continue;
			}
			while ((sb.length() > 0) && c < sb.charAt(sb.length() - 1)
					&& count[sb.charAt(sb.length() - 1) - 'a'] != 0) {
				visited[sb.charAt(sb.length() - 1) - 'a'] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(c);
			visited[index] = true;
		}
		return sb.toString();
	}
	
	public static String removeDuplicateLetters2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		Stack<Character> stack = new Stack<Character>();
		Set<Character> set = new HashSet<Character>();
		for (char c : s.toCharArray()) {
			if(set.contains(c)){
				continue;
			}
			if (stack.isEmpty()) {
				stack.push(c);
				set.add(c);
			} else {
				while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) >= 2) {
					map.put(stack.peek(), map.get(stack.peek()) - 1);
					set.remove(stack.peek());
					stack.pop();
				}
				if (!set.contains(c)) {
					stack.push(c);
					set.add(c);
				} else {
					map.put(c, map.get(c) - 1);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
    }

	public static void main(String[] args) {
		//System.out.println(removeDuplicateLetters("bcabc"));
		//System.out.println(removeDuplicateLetters("cbbbcaa"));
		System.out.println(removeDuplicateLetters2("abacb"));
		System.out.println(removeDuplicateLetters("acabc"));
	}
}
