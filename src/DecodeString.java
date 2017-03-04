//394
public class DecodeString {
	public static String decodeString(String s) {
		if(s == null || s.length() == 0){
            return "";
        }
        while(s.indexOf('[') != -1){
            int leftBracket = s.lastIndexOf('[');
            int leftNum = leftBracket - 1;
            while(leftNum >= 0 && Character.isDigit(s.charAt(leftNum))){// notice leftNum should be greadter than 0
                leftNum--;
            }
            int num = Integer.parseInt(s.substring(leftNum + 1, leftBracket));
            String str = s.substring(leftBracket + 1, s.indexOf(']', leftBracket));
            StringBuilder newStr = new StringBuilder();
            for(int i = 0; i < num; i++){
                newStr.append(str);
            }
            s = s.substring(0, leftNum + 1) + newStr.toString() + s.substring(s.indexOf(']', leftBracket) + 1);
        }
        return s;
    }
	public static void main(String[] args) {
		System.out.println(decodeString("3[a2[c]]"));
	}
}
/*
 * 1. Line 10, didn't check leftNum should be greater than 0
 * */
