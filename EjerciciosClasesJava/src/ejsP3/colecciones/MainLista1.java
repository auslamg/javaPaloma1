package ejsP3.colecciones;
import java.util.ArrayList;
import java.util.List;

public class MainLista1 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		List<Integer> Lista1 = new ArrayList<>();

		Lista1.add(0);
		Lista1.clear();

		Integer i = 42;

		Lista1.add(0);
		System.err.println("Añadiendo i " + Lista1.add(i));

		System.out.println("Contiene 42: " + Lista1.contains(42));

		System.out.println("IsEmpty: " + Lista1.isEmpty());
/* 		System.out.println("Remove 1: " + Lista1.remove(1));
 */		Lista1.remove(1);
		System.out.println("Remove i: " + Lista1.remove(i));

		Lista1.set(0, 36);

		System.out.println(Lista1.size());
		Integer[] arrayCast = Lista1.toArray(new Integer[5]);

		Lista1.clear();

		Lista1.add(0, i);
		Integer myInt = Lista1.get(0);
		Lista1.remove(0);
		Lista1.set(0, myInt);
	}
}
