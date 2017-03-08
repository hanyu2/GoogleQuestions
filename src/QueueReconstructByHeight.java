import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructByHeight {
	public static int[][] reconstructQueue(int[][] people) {
		if(people.length == 0 || people == null){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]){
					return o1[1] - o2[1];
				}else{
					return o1[0] - o2[0];
				}
			}
        });
        int[][] res = new int[people.length][2];
        for(int[] r : res){
            r[0] = -1;
        }
        for(int[] p : people){
        	int position = findPosition(res, p);
        	res[position][0] = p[0];
        	res[position][1] = p[1];
        }
        return  res;
    }
	public static int findPosition(int[][] res, int[] p){
		int count = 0;
		for(int i = 0; i < res.length; i++){
			if(res[i][0] == -1 && count == p[1]){
				return i;
			}
			if(res[i][0] == -1 || res[i][0] == p[0]){
				count++;
			}
		}
		return res.length - 1;
	}
	
	public static int[][] reconstructQueue2(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = reconstructQueue2(people);
		System.out.print(res);
	}
}
