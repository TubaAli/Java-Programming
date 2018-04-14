package trees;

import trees.GenericTree;

public class Client {

	public static void main(String[] args) {
		GenericTree gt1 = new GenericTree();
//		GenericTree gt2 = new GenericTree();
//		 10 3 20 2 50 0 60 0 30 3 70 2 110 0 120 0 80 0 90 0 40 1 100 0
//		gt.preO();
//		gt.postO();
//		gt1.multisolver();
		gt1.levelZZ();
		System.out.println(gt1.AreIdenticallyShaped(gt1));
		
//		gt1.isMirrorItself();
	}

}
