package BinaryTrees;

public class AVLClient {

	public static void main(String[] args) {
		AVL a = new AVL(new int[] {12,25,37,50,62,75,87});
//		a.display();
		
		a.add(40);
		a.add(38);
		a.remove(12);
		a.display();
		
	}

}
