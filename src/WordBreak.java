import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for(String str : wordDict){
            set.add(str);
        }
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(start, i + 1);
            if(set.contains(str)){
                start = i + 1;
            }
        }
        return start == s.length();
    }
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>(Arrays.asList("aaaa","aaa"));
		System.out.println(wordBreak("aaaaaaa", wordDict));
	}
}

