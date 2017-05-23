import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortCharactersByFrequency {
	public static String frequencySort(String s) {
		if (s.length() <= 1) {
			return s;
		}
		Map<Integer, Set<Character>> map = new HashMap<Integer, Set<Character>>();
		Map<Character, Integer> times = new HashMap<Character, Integer>();
		int max = 0;
		for (char c : s.toCharArray()) {
			if (!times.containsKey(c)) {
				times.put(c, 1);
				if (map.containsKey(1)) {
					Set<Character> set = map.get(1);
					set.add(c);
				} else {
					Set<Character> set = new HashSet<Character>();
					set.add(c);
					map.put(1, set);
				}
			} else {
				int t = times.get(c);
				map.get(t).remove(c);
				t++;
				if (map.containsKey(t)) {
					Set<Character> set = map.get(t);
					set.add(c);
				} else {
					Set<Character> set = new HashSet<Character>();
					set.add(c);
					map.put(t, set);
				}
				times.put(c, t);
			}
			max = Math.max(max, times.get(c));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = max; i >= 0; i--) {
			if (map.containsKey(i)) {
				Set<Character> set = map.get(i);
				if (set.size() > 0) {
					for (char c : set) {
						sb.append(build(c, i));
					}
				}
			}
		}
		return sb.toString();
	}

	public static String build(char c, int t) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(frequencySort("Aabb"));
	}
}
