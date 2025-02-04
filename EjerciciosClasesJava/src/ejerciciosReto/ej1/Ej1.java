package ejerciciosReto.ej1;

import java.util.Scanner;

public class Ej1 {
	//P [1-30] //Pisos del portal
	//L [1-26] //Letras del portal
	//A [1-1,000] //Asistentes

	//Pisos Letras Asistentes
	/* 
	 * total = P*L
	 * 
	 * 
	 */

	public Ej1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Entrada");

		while (scn.hasNextLine()) {
			String input = scn.nextLine();
			System.out.println(input.replaceAll(" ", ""));

			Instruccion reunionActual = null;
			if (input.replaceAll(" ", "").length() == 3) {
				int numVal = Integer.parseInt(input);

				int p = numVal%100;
				int l = numVal%10;
				int a = numVal%1;

				System.out.println("Reunion creada:" + p +" "+ l +" "+ a);
				reunionActual = new Instruccion(p, l, a);
			}
			if (reunionActual != null) {
				int totalApartamentos = reunionActual.pisos * reunionActual.letras;
				int asistentes = reunionActual.asistentes;

				String input2 = scn.nextLine();


			}
			else {
				System.err.println("ERROR: Null action");
			}
			
		}

		
	}

	void Contains() {
			
	}

	
}

class Instruccion{
	int pisos;
	int letras;
	int asistentes; 

    public Instruccion(int p, int l, int a) {
		this.pisos = p;
		this.letras = l;
		this.asistentes = a;
    }	
}

class Apt{
	String dir;
	public Apt(String dir) {
		this.dir = dir;
	}		
}
