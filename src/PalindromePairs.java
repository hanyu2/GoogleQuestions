import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(words == null || words.length < 2){
			return res;
		}
		Map<String, Integer> index = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++){
			index.put(words[i], i);
		}
		for(String word : words){
			for(int i = 0; i <= word.length(); i++){
				String left = word.substring(0, i);
				String right = word.substring(i);
				if(isPalindrome(left)){
					StringBuilder sb = new StringBuilder(right);
					String rev = sb.reverse().toString();
					if(index.containsKey(rev) && !rev.equals(word)){
						List<Integer> pair = new ArrayList<Integer>(Arrays.asList(index.get(rev), index.get(word)));
						res.add(pair);
					}
				}
				if(isPalindrome(right)){
					StringBuilder sb = new StringBuilder(left);
					String rev = sb.reverse().toString();
					//check right.length() != 0 to avoid duplicates
					if(index.containsKey(rev) && !rev.equals(word) && right.length() != 0){
						List<Integer> pair = new ArrayList<Integer>(Arrays.asList(index.get(word), index.get(rev)));
						res.add(pair);
					}
				}
			}
		}
		return res;
	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		List<List<Integer>> list = palindromePairs(words);
		System.out.println(list.size());
	}
}
