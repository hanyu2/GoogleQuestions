import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTree {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n == 0 || edges.length == 0){
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(map.get(i).size() == 1){
                q.offer(i);
            }
        }
        
        while(n > 2){
            int size = q.size();
            n -= size;
            for(int i = 0; i < size; i++){
                int x = q.poll();
                for(int nei : map.get(x)){
                    map.get(nei).remove(x);
                    if(map.get(nei).size() == 1){
                        q.offer(nei);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
	public static void main(String[] args) {
		int[][] edges = {{0, 1}, {0, 2}};
		List<Integer> res = findMinHeightTrees(3, edges);
	}
}
