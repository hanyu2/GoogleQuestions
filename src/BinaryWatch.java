import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= num; i++){
            List<Integer> hours = hour(i);
            List<Integer> mins = min(num - i);
            for(Integer h : hours){
                for(Integer m : mins){
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(":");
                    if(m < 10){
                        sb.append("0").append(m);
                    }else{
                        sb.append(m);
                    }
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
    public List<Integer> hour(int n){
        List<Integer> list = new ArrayList<Integer>();
        searchHour(0, 0, n, list);
        return list;
    }
    public List<Integer>  min(int n){
        List<Integer> list = new ArrayList<Integer>();
        searchMin(0, 0, n, list);
        return list;
    }
    public void searchHour(int index, int sum, int n, List<Integer> list){
        if(n < 0 || index > 4){
            return;
        }
        if(n == 0 && sum >= 0 && sum <= 11){
            list.add(sum);
            return;
        }
        searchHour(index + 1, sum + (int)Math.pow(2, index), n - 1, list);
        searchHour(index + 1, sum, n, list);
    }
    public void searchMin(int index, int sum, int n, List<Integer> list){
        if(n < 0 || index > 7){
            return;
        }
        if(n == 0 && sum >= 0 && sum <= 59){
            list.add(sum);
            return;
        }
        searchMin(index + 1, sum + (int)Math.pow(2, index), n - 1, list);
        searchMin(index + 1, sum, n, list);
    }
    public static void main(String[] args) {
		BinaryWatch bw = new BinaryWatch();
		List<String> list = bw.readBinaryWatch(2);
		for(String l : list){
			System.out.println(l);
		}
	}
}
