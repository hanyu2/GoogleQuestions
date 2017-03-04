//482
public class LicenseKeyFormatting {
	public static String licenseKeyFormatting(String S, int K) {
		S = S.replace("-", "");
		S = S.toUpperCase();
		StringBuilder newLicense = new StringBuilder();
		while(S.length() > K){
			newLicense.insert(0, "-" + S.substring(S.length() - K));
			S = S.substring(0, S.length() - K);
		}
		newLicense = newLicense.insert(0, S);
		return newLicense.toString();
	}
	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
		System.out.println(licenseKeyFormatting("2-4A0r7-4k", 3));
	}
}
/*
 * All key letters are upper case
 * */
