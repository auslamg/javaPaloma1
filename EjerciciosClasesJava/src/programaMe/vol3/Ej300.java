package programaMe.vol3;

import java.util.Scanner;

//DONE
public class Ej300 {
	
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int readCount = scn.nextInt();

        for (int i = 0; i < readCount; i++) {
            String palabra = scn.next();
			String salida =	TestWord(palabra) ? "SI" : "NO";

			System.out.println(salida);            
        }
    }

	
    private static boolean TestWord(String word) {
		boolean hasA = false;
		boolean hasE = false;
		boolean hasI = false;
		boolean hasO = false;
		boolean hasU = false;

        char[] charArray = word.toCharArray();
		for (char c : charArray) {
			switch (c) {
				case 'a' :
					hasA = true;
						break;
					case 'e':
						hasE = true;
						break;
					case 'i':
						hasI = true;
						break;
					case 'o':
						hasO = true;
						break;
					case 'u':
						hasU = true;
						break;
			}
		}

		return hasA && hasE && hasI && hasO && hasU;
    }

}
