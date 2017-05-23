import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (s.length() == 0 || wordDict.size() == 0) {
			return res;
		}
		Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
		return dfs(0, s, wordDict, cache);
	}

	public static List<String> dfs(int start, String s, List<String> words, Map<Integer, List<String>> cache) {
		if (cache.containsKey(start)) {
			return cache.get(start);
		} else {
			List<String> res = new ArrayList<String>();
			for (int i = start; i < s.length(); i++) {
				String sub = s.substring(start, i + 1);
				if (words.indexOf(sub) != -1) {
					List<String> last;
					if (i != s.length() - 1) {
						last = dfs(i + 1, s, words, cache);
						for (String lastStr : last) {
							res.add(sub + " " + lastStr);
						}
					} else {
						res.add(sub);
					}
				}
			}
			cache.put(start, res);
			return res;
		}
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>(Arrays.asList("a", "abc", "b", "cd"));
		List<String> res = wordBreak("abcd", wordDict);
	}
}
