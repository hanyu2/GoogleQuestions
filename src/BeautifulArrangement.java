import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {
	public static int countArrangement(int N) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= N; i++) {
			set.add(i);
		}
		return search(1, set);
	}

	public static int search(int index, Set<Integer> set) {
		if (set.size() == 0) {
			return 1;
		}
		int count = 0;
		for (int num : set) {
			if (num % index == 0 || index % num == 0) {
				Set<Integer> temp = new HashSet<Integer>(set);
				temp.remove(num);
				count += search(index + 1, temp);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(countArrangement(2));
	}
}
