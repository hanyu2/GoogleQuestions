
public class MaximumProductOfWordLengths {
	public static int maxProduct(String[] words) {
        if(words.length <= 1){
            return 0;
        }
        int[] decs = new int[words.length];
        for(int i = 0; i < words.length; i++){
            decs[i] = convert(words[i]);
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
            	int x = decs[i] & decs[j];
                if(x == 0){
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
    public static int convert(String s){
        int n = 0;
        for(char c : s.toCharArray()){
            n |= (1 << (int)(c - 'a'));
        }
        return n;
    }
    public static void main(String[] args) {
    	String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    	System.out.println(maxProduct(words));
	}
}
