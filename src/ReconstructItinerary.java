import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public static List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String[] str : tickets){
            List<String> list;
            if(map.containsKey(str[0])){
                list = map.get(str[0]);
            }else{
                list = new ArrayList<String>();
            }
            list.add(str[1]);
            map.put(str[0], list);
        }
        for(String s : map.keySet()){
        	List<String> list = map.get(s);
        	Collections.sort(list, new Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareTo(s2);
				}
			});
        }
        
        res.add("JFK");
    	for(int i = 0; i < map.get("JFK").size(); i++){
    		res.add(map.get("JFK").get(i));
    		String str = map.get("JFK").remove(i);
    		if(dfs(res, map, str, tickets.length - 1)){
    			return res;
    		}
    		map.get("JFK").add(i, str);
    		res.clear();
    		res.add("JFK");
    	}
        return res;
    }

	private static boolean dfs(List<String> res, Map<String, List<String>> map, String str, int count) {
		if(count <= 0){
			return true;
		}
		if(!map.containsKey(str)){
			return false;
		}
		for(int i = 0; i < map.get(str).size(); i++){
			res.add(map.get(str).get(i));
			String next = map.get(str).remove(i);
			if(dfs(res, map, next, count - 1)){
				return true;
			}else{
				map.get(str).add(i, next);
				res.remove(res.size() - 1);
			}
		}
		return false;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });
        ListNode head = dummy;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if(node.next != null){
                pq.offer(head.next);
            }
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		String[][] tickets = {{"JFK","AAA"},{"AAA","JFK"},{"JFK","BBB"},{"JFK","CCC"},{"CCC","JFK"}};
		List<String> list = findItinerary(tickets);
	}
	
}
