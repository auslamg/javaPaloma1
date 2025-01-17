package ej_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class EjArraylist {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> myList = new ArrayList<>();

		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.add(60);
		myList.add(70);

		myList.clear();
		AskForListElements(myList);

		System.out.println(Average(myList));
		System.out.println(DataCount(myList));
		System.out.println(Sum(myList));
	}

	static void AskForListElements(ArrayList<Integer> myList) {
		try (Scanner scn = new Scanner(System.in)) {
			Integer nextNum;
			
			do {
				System.out.println("Type a value for the arraylist");


				if (scn.hasNextInt()) {
					nextNum = scn.nextInt();
					myList.add(nextNum);
				}
				
				else {
					nextNum = 1;
					System.out.println("Invalid input.");
				} 

			} while (nextNum > 0);
		}
	}

	static Integer Average(ArrayList<Integer> myList){
		return 0;
	}

	static Integer DataCount(ArrayList<Integer> myList) {
		return myList.size();
	}

	static Integer Sum(ArrayList<Integer> myList) {
		Integer sum = 0;
		for (Integer i : myList) {
			sum += i;
		}
		return sum;
	}

}
