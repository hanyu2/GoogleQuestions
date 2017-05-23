
public class SmallGoodBase {
	public static String smallestGoodBase(String n) {
		if(Long.toBinaryString(Long.parseLong(n)).replace("1", "").length() == 0){
			return "2";
		}
		int len = Long.toBinaryString(Long.parseLong(n)).length();
		long num = Long.parseLong(n);
		while (len >= 1) {
			long left = 1;
			long right = num;
			while (left <= right) {
				long mid = (left + right) / 2;
				long res = getPow(mid, len);
				if (res == num) {
					return String.valueOf(mid);
				} else if (res > num) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			len--;
		}
		return "1";
	}

	public static long getPow(long n, int len) {
		long res = 0;
		int i = 0;
		while (i < len) {
			res = res + (long) (Math.pow(n, i));
			i++;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(smallestGoodBase("2251799813685247"));
	}
}
