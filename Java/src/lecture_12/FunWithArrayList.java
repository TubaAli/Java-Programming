package lecture_12;

import java.util.ArrayList;

public class FunWithArrayList {

	public static void main(String[] args) {
		int[] one = { 1, 1, 3, 3, 5, 6, 10, 11, 15 };
		int[] two = { 1, 2, 3, 4, 8, 9, 10 };

		ArrayList<Integer> a = gce(one, two);
		System.out.print(a);
	}

	private static ArrayList<Integer> gce(int[] one, int[] two) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] == two[j]) {
				a.add(one[i]);
				i++;
				j++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				i++;
			}
		}
		return a;
	}

}
