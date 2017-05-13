import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	/** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int count;
    public FindMedianFromDataStream() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
        count = 0;
    }
    
    public void addNum(int num) {
        count++;
        if(min.isEmpty()){
        	if(max.isEmpty()){
        		max.add(num);
        	}else{
        		if(num <= max.peek()){
        			max.add(num);
        			min.add(max.poll());
        		}else{
        			max.add(num);
        		}
        	}
        }else{
        	if(num <= max.peek()){
        		max.add(num);
        	}else{
        		min.add(num);
        		max.add(min.poll());
        	}
        }
        if(max.size() - min.size() == 2){
        	min.add(max.poll());
        }
    }
    
//    public void addNum(int num) {
//        max.offer(num);
//        min.offer(max.poll());
//        if (max.size() < min.size()){
//            max.offer(min.poll());
//        }
//    }
    
    public double findMedian() {
        if(count % 2 == 1){
        	return (double)max.peek();
        }else{
        	return (double)(max.peek() + min.peek()) / 2.0;
        }
    }
}
//40, 12, 16