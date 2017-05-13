import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	//Be careful of cycles
	//Be careful of the result returned whwen there are many branches and some didn't find the solution
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
        double[] res = new double[queries.length];
        for(int i = 0; i < equations.length; i++){
            if(!graph.containsKey(equations[i][0])){
                Map<String, Double> map = new HashMap<String, Double>();
                map.put(equations[i][1], values[i]);
                graph.put(equations[i][0], map);
            }else{
                Map<String, Double> map = graph.get(equations[i][0]);
                map.put(equations[i][1], values[i]);
            }
            if(!graph.containsKey(equations[i][1])){
                Map<String, Double> map = new HashMap<String, Double>();
                map.put(equations[i][0], 1/values[i]);
                graph.put(equations[i][1], map);
            }else{
                Map<String, Double> map = graph.get(equations[i][1]);
                map.put(equations[i][0], 1/values[i]);
            }
        }
        for(int j = 0; j < queries.length; j++){
            if(!graph.containsKey(queries[j][0]) || !graph.containsKey(queries[j][1])){
                res[j] = -1.0;
            }else if(queries[j][0].equals(queries[j][1])){
                res[j] = 1.0;
            }else{
                Set<String> visited = new HashSet<String>();
                res[j] = query(graph, queries[j][0], queries[j][1], 1.0, visited);
            }
        }
        return res;
    }
	public static double query(Map<String, Map<String, Double>> graph, String start, String end, double product, Set<String> visited){
        Map<String, Double> map = graph.get(start);
        visited.add(start);
        for(String s : map.keySet()){
        	if(visited.contains(s)){
        		continue;
        	}
            if(s.equals(end)){
                return product * map.get(s);
            }else{
                double temp = query(graph, s, end, product * map.get(s), visited);
                if(temp != -1.0){
                	return temp;
                }
            }
        }
        return -1.0;
    }
	public static void main(String[] args) {
		String[][] equations = { {"a","b"},{"e","f"}, {"b","e"} };
		double[] values = {3.4, 1.4, 2.3};
		String[][] queries = {{"b","a"},{"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"}};
		double[] res = calcEquation(equations, values, queries);
	}
}
