package lecture_17;

public class exponential {

	public static void main(String[] args) {
		int n = 8;
		int x = 2;
		int a = func(n,x);
		System.out.println(a);
	}

	private static int func(int n, int x) {
		int sum = 0;
		int a = (int)Math.pow(x, n);
		for(int i=1; i<=n; i++){
			sum+=i*a;
			a/=x;
		}
		return sum;
	}

}
