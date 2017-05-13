import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
	Map<Integer, Integer> map;
	List<Integer> list;

	public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if(map.containsKey(val)){
			return false;
		}
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if(!map.containsKey(val)){
			return false;
		}
		int index = map.get(val);
		if(index < list.size() - 1){
			list.set(index, list.get(list.size() - 1));
			map.put(list.get(list.size() - 1), index);
		}
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get((int)(Math.random() * list.size()));
	}
}
