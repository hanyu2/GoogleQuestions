import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
    	int key;
		int value;
    	Node prior;
    	Node next;
    	public Node(int key, int value) {
    		this.key = key;
			this.value = value;
		}
    }
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
    	head.next = tail;
    	tail.prior = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
        	return -1;
        }
        Node n = map.get(key);
        pop(n);
        insertHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
        	Node n = new Node(key, value);
        	map.put(key, n);
        	insertHead(n);
        	if(map.size() > capacity){
        		Node t = tail.prior;
        		pop(t);
        		map.remove(t.key);
        	}
        }else{
        	Node n = map.get(key);
        	pop(n);
        	n.value = value;
        	map.put(key, n);
        	insertHead(n);
        }
    }
    
    public void insertHead(Node n){
    	n.next = head.next;
    	n.next.prior = n;
    	head.next = n;
    	n.prior = head;
    }
    public void pop(Node n){
    	n.next.prior = n.prior;
    	n.prior.next = n.next;
    }
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}