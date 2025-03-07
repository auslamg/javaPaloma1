package programaMe.vol7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej768 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			while (true) {
				String serie = in.nextLine();
				CasoPrueba(serie);
			}
		} catch (Exception e) {

		}
	}

	private static void CasoPrueba(String serie) throws Exception {
		char[] ca = serie.toCharArray();
		
		if (ca.length < 1) {
			throw new Exception();
		}

		Map<Character, Integer> cMap = new TreeMap<>();
		for (char c : ca) {
			if (cMap.containsKey(c)) {
				cMap.put(c, cMap.get(c) + 1);
			}
			else
			cMap.put(c,1);
		}

		for (Character character : cMap.keySet()) {
			if (cMap.get(character) >= ( (ca.length/2)) ) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("SÍ");
	}

}
