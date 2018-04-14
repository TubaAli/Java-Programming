package classesObjects;

public class Stackstory {
	public static void main(String[] args) {

//		boolean b = AreTheParenthesisBalanced("[{(a+b)+(c+d)}+e]");
//		if (b == true) {
//			System.out.println("balanced");
//		} else {
//			System.out.println("not balanced");
//		}
		
		boolean b = AreTheParenthesisExtra("(((a+b)+c))");
		if (b == true) {
			System.out.println("No extra brackets");
		} else {
			System.out.println("extra brackets");
		}
		// s.push(10);
		// s.push(20);
		// s.push(30);
		// s.push(40);
		// s.push(50);
		// s.push(60);
		// s.display();
		// s.pop();
		// s.pop();
		// s.pop();
		// s.pop();
		// s.pop();
		// s.pop();
	}

	public static boolean AreTheParenthesisBalanced(String str) {
		Stack s = new Stack(str.length());

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				s.push(str.charAt(i));
			} else if (str.charAt(i) == '}') {
				if (s.size() == 0) {
					return false;
				} else if (s.top() == '{') {
					s.pop();
				}
			} else if (str.charAt(i) == ']') {
				if (s.size() == 0) {
					return false;
				} else if (s.top() == '[') {
					s.pop();
				}
			} else if (str.charAt(i) == ')') {
				if (s.size() == 0) {
					return false;
				} else if (s.top() == '(') {
					s.pop();
				}
			}
		}
		if (s.size() == 0) {
			return true;
		} else
			return false;
	}
	
	public static boolean AreTheParenthesisExtra(String str){
		Stack s = new Stack(str.length());
		
		for(int i=0; i<str.length(); i++){
			s.push(str.charAt(i));
			if(str.charAt(i)=='+' || str.charAt(i)=='/' || str.charAt(i)=='*' || str.charAt(i)=='-'){
				s.pop();
				s.push(str.charAt(i));
			}
			if(str.charAt(i)==')'){
				if(s.size()==0){
					return false;
				}
				else if(s.top()=='+' || s.top()=='/' || s.top()=='*' || s.top()=='-'){
					s.pop();
					if(s.top()=='('){
						s.pop();
					}
				}
			}
		}
		if(s.size()==0){
			return true;
		}
		else return false;
	}
}
