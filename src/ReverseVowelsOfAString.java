
public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        while(left < right){
            while(left < right && !isVowel(ch[left])){
                left++;
            }
            while(left < right && !isVowel(ch[right])){
                right--;
            }
            if(left != right){
                swap(ch, left, right);
                left++;
                right--;
            }
        }
        return String.valueOf(ch);
    }
    public boolean isVowel(char c){
        char ch = Character.toLowerCase(c);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public void swap(char[] ch, int left, int right){
        char temp = ch[left];
        ch[left] = ch[right];
        ch[right] = temp;
    }
}
