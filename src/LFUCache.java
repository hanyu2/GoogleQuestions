import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class LFUCache {
	//http://blog.csdn.net/u011604052/article/details/54767281

	private TreeMap<Integer, LinkedHashSet<Integer>> numTreeMap; // k:num,v:timeLinkedHashSet
	private HashMap<Integer, int[]> valueHashMap; // k:key,v:int[value,num]
	private int capacity;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		numTreeMap = new TreeMap<>();
		valueHashMap = new HashMap<>();
	}

	public int get(int key) {
		if (!valueHashMap.containsKey(key)) {
			return -1;
		}
		int v = valueHashMap.get(key)[0];
		plusToTreeMap(key);
		return v;
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (valueHashMap.containsKey(key)) {
			plusToTreeMap(key);
			valueHashMap.put(key, new int[] { value, valueHashMap.get(key)[1] });
		} else {
			if (valueHashMap.size() == capacity) {
				// System.out.println("remove!");
				removeFromCache();
			}
			valueHashMap.put(key, new int[] { value, 1 });
			addToTreeMap(key);
		}
	}

	private void addToTreeMap(int key) {
		LinkedHashSet<Integer> timeLinkedList;
		if (!numTreeMap.containsKey(1)) {
			timeLinkedList = new LinkedHashSet<>();
			numTreeMap.put(1, timeLinkedList);
		} else {
			timeLinkedList = numTreeMap.get(1);
		}
		timeLinkedList.add(key);
	}

	private void plusToTreeMap(int key) {
		LinkedHashSet<Integer> timeLinkedList;
		int num = valueHashMap.get(key)[1]++;
		timeLinkedList = numTreeMap.get(num);
		timeLinkedList.remove(key);
		if (timeLinkedList.size() == 0) {
			numTreeMap.remove(num);
		}
		if (!numTreeMap.containsKey(num + 1)) {
			timeLinkedList = new LinkedHashSet<>();
			numTreeMap.put(num + 1, timeLinkedList);
		} else {
			timeLinkedList = numTreeMap.get(num + 1);
		}
		timeLinkedList.add(key);
	}

	private void removeFromCache() {
		LinkedHashSet<Integer> timeLinkedList = numTreeMap.firstEntry().getValue();
		int k = timeLinkedList.iterator().next();
		timeLinkedList.remove(k);
		valueHashMap.remove(k);
		if (timeLinkedList.size() == 0) {
			numTreeMap.remove(numTreeMap.firstEntry().getKey());
		}
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */