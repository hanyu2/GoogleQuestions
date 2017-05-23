
public class StudentAttendanceRecordII {
	static int count = 0;
    public static int checkRecord(int n) {
        search(n, "", false);
        return count;
    }
    public static void search(int n, String s, boolean a){
        if(n == 0){
        	System.out.println(s);
            count++;
            return;
        }
        if(!a){
        	search(n - 1, s + "A", true);
        }
        if(s.length() >= 2){
        	if(!(s.charAt(s.length() - 1) == 'L' && s.charAt(s.length() - 2) == 'L')){
        		search(n - 1, s + "L", a);
        	}
        }else{
        	search(n - 1, s + "L", a);
        }
        search(n - 1, s + "P", a);
    }
    public static void main(String[] args) {
		System.out.println(checkRecord(4));
	}
}
