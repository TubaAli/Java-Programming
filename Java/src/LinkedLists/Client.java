package LinkedLists;

public class Client {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.display();

		list.addFirst(0);
//		list.addAt(45, 7);
		list.display();

		list.removeAt(0);
		list.removeAt(7);
		list.display();
		
		list.reverseDataIteratively();
		list.display();
		
		list.reversePointerIteratively();
		list.display();
		
		list.displayReverse();
		System.out.println();
		list.display();
		
		System.out.println("____________________________");
		list.reversePointerRecursively();
		list.display();
		
		System.out.println("-------------------------------");
		list.reverseDataRecursively();
		list.display();
		
//		System.out.println("................");
//		list.fold();
//		list.display();
		
//		System.out.println(list.IsPalindrome());
		
		System.out.println(list.mid());
	}

}
