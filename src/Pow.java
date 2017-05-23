
public class Pow {
	public static double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(n < 0){
            x = 1/x;
        }
        return pow(x, n);
    }
    public static double pow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
    public static void main(String[] args) {
		System.out.println(myPow(3.89707, 2));
	}
}
