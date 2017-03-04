
public class PlusOne {
	public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return digits;
        }
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int num = digits[i] + carry;
            digits[i] = num % 10;
            carry = num / 10;
        }
        if(carry != 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for(int i = 1; i < newDigits.length; i++){
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }else{
            return digits;
        }
    }
}
