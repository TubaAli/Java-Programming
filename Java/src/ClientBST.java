import BinaryTrees.BST;

public class ClientBST {

	public static void main(String[] args) {
		int[] arr = {12,25,37,50,62,75,87}; 
		BST b = new BST(arr);
		b.display();
		System.out.println(b.max()); //similarly other functions
		
		b.printInRange(25,87);
	}

}
