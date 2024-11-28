package ej_examen;

import ej_examen.Pieza.Color;
import ej_examen.Pieza.TipoPieza;

public class Ejercicio4AjedrezMain {

	public static void main(String[] args) {
		//Construye el tablero
		//8 filas, 8 columnas
		JuegoAjedrez juegoAjedrez = new JuegoAjedrez();

		//Obtener movimiento de torre blanca
		System.out.println(TipoPieza.R.getTipoMovimiento());
		
				//Poner reina blanca en 3,3
				juegoAjedrez.ponerPieza((byte) 3, (byte) 3, new Pieza(TipoPieza.Q, Color.B));
		
				//Poner rey blanco en 5,5
				juegoAjedrez.ponerPieza((byte) 5, (byte) 5, new Pieza(TipoPieza.K, Color.B));
		
				//Mostrar piezas y su posición
				juegoAjedrez.mostrarSituacionPiezasTablero();
			}
		
		}
		
		
class Pieza {
	enum TipoPieza {
			R, //Rook
			N, //kNight
			B, //Bishop
			K, //King
			Q, //Queen
			P; //Pawn
	
			//TODO
			String getTipoMovimiento() {
				return "La torre se mueve en horizontal y vertical";
			} 
	}

	enum Color {
		B, //Blanco
		N //Negro
	}

	TipoPieza tipoPieza;
	Color color;

	public Pieza(TipoPieza tipoPieza, Color color) {
		this.tipoPieza = tipoPieza;
		this.color = color;
	}
}

class JuegoAjedrez {

	Pieza[][] piezasEnTablero = new Pieza[8][8];

	void ponerPieza(byte fila, byte columna, Pieza pieza){
		piezasEnTablero[fila - 1][columna - 1] = pieza;
	}

    void mostrarSituacionPiezasTablero() {
        for (int i = 0; i < piezasEnTablero.length; i++) {
			for (int j = 0; j < piezasEnTablero[i].length; j++) {

				if (piezasEnTablero[i][j] != null) {
					System.out.println("");					
				}
				
			}
		}
    }
}
