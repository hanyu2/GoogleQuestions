
public class MagicString {
	public static int magicalString(int n) {
		if(n == 0){
			return 0;
		}
        if(n <= 3){
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(122);
        int pointer = 2;
        boolean istwo = false;
        int count = 1;
        while(sb.length() < n){
            if(sb.charAt(pointer) == '2'){
                if(istwo){
                    sb.append("22");
                    istwo = false;
                }else{
                    sb.append("11");
                    count += 2;
                    istwo = true;
                }
            }else{
                if(!istwo){
                    sb.append("1");
                    istwo = true;
                    count++;
                }else{
                    sb.append("2");
                    istwo = false;
                }
            }
            pointer++;
        }
        if(sb.length() > n && sb.charAt(sb.length() - 1) == '1'){
        	count--;
        }
        return count;
    }
    public static void main(String[] args) {
		System.out.println(magicalString(13));
	}
}
