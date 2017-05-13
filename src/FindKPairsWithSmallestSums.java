import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	class Node{
        int[] array;
        int sum;
        int index;
        public Node(int index, int x1, int x2){
        	this.index = index;
        	array = new int[]{x1, x2};
        	this.sum = x1 + x2;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0){
            return res;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k, new Comparator<Node>() {
        	public int compare(Node n1, Node n2){
        		return n1.sum - n2.sum;
        	}
		});
        for(int i = 0; i < nums1.length && i < k; i++){
        	pq.offer(new Node(0, nums1[i], nums2[0]));
        }
        for(int i = 0; i < k; i++){
        	if(pq.isEmpty()){
        		break;
        	}
        	Node n = pq.poll();
        	res.add(n.array);
        	int next = n.index + 1;
        	if(next < nums2.length){
        		pq.offer(new Node(next, n.array[0], nums2[next]));
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		FindKPairsWithSmallestSums f = new FindKPairsWithSmallestSums();
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		f.kSmallestPairs(nums1, nums2, 3);
	}
}
