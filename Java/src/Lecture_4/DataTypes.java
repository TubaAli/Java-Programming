package Lecture_4;

import java.util.Scanner;

public class DataTypes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		int bitCount = sc.nextInt();
//		System.out.println(isTheBitSet(num,bitCount));
//		printBits(num);
		getLastSetBit(num);
		getLastSetBitBetter(num);
	}

	public static boolean isTheBitSet(int num, int bitCount){
	 int mask = 1<<bitCount;
	 if((num&mask)==mask)
	 return true;
	 else return false;
    }
	
	public static void printBits(int num) {
		int i = 31;
		while (i >= 0) {
			int mask = 1<<i;
			if((num&mask)==mask)
				System.out.print("1");
			else System.out.print("0");
			i--;
		}
}
	public static void getLastSetBit(int num){
		int i = 0;
		int mask = 0;
		while(i<=31){
			mask = 1<<i;
			if((num&mask)==mask)
				break;
			else i++;
		}
		System.out.print(mask);
	}
	
	public static void getLastSetBitBetter(int num){
		int negNum = -num;
		int mask = num&negNum;
		System.out.print(mask);
	}
}
