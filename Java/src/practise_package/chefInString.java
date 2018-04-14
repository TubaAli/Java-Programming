package practise_package;

public class chefInString {

	public static void main(String[] args) {
		String str = "ihgyjfchefisgoodforporogewss";
		boolean[] b = new boolean[4];
		int p = getLine(str, b);
		System.out.println(p);
	}

	private static int getLine(String str, boolean[] b) {

		for (int i = 0; i < str.length() - 1; i++) {
			if (b[0] == true && b[1] == true && b[2] == true && b[3] == true) {
				return i - 4;
			}
			if (str.charAt(i) == 'c' && b[0] == false) {
				b[0] = true;
			}
			if (str.charAt(i) == 'h' && b[1] == false) {
				b[1] = true;
			}
			if (str.charAt(i) == 'e' && b[2] == false) {
				b[2] = true;
			}
			if (str.charAt(i) == 'f' && b[3] == false) {
				b[3] = true;
			}
		}
		return -1;
	}
}
