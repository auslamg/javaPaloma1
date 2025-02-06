package programaMe.vol1;

import java.util.Arrays;
import java.util.Scanner;

//DONE
public class Ej100 {

	final static int K = 6174;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numCount = scn.nextInt();

		for (int i = 0; i < numCount; i++) {
			System.out.write( stepsToK(scn.nextInt()));
		}
		scn.close();
	}

	static int[] toAscendingArray(int v) {
		int digitNumber = String.valueOf(v).length();
		
		int[] individualNumbers = new int[digitNumber];
		
		int currentPower = (int) Math.pow(10, digitNumber - 1);
		int currentRemainder = v;

		for (int i = 0; i < digitNumber; i++) {
			int newDigit = (currentRemainder - (currentRemainder%currentPower))/currentPower;
			individualNumbers[i] = newDigit;

			currentRemainder = currentRemainder%currentPower;
			currentPower/=10;
		}

		Arrays.sort(individualNumbers);

		return individualNumbers;
	}

	static int[] flipArray(int[] a) {
		int[] b = new int[a.length];
		for (int i = a.length-1; i >= 0; i--) {
			 b[a.length-1-i] = a[i];
		}
		return b;
	}

	static int arrayToNum(int[] a) {
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			int digit = a[a.length-1-i];
			n += digit * Math.pow(10, i);
		}
		return n;
	}

	static int stepsToK(int n) {
		int counter = 0;

		if (n == K) {
			return 0;			
		}
		while (n != K) { 
			int n1 = arrayToNum( flipArray(toAscendingArray(n)) );
			int n2 = arrayToNum( toAscendingArray(n) );
			
			n = n1 - n2;
			counter++;
		}

		
		return counter+1;
	}

}
