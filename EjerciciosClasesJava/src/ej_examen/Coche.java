package ej_examen;

/*Crea una clase Coche

- Se debe poder elegir un modelo entre SUPRA, IBIZA, PASSAT
- Existen las marcas TOYOTA, SEAT, VOLKSWAGEN, que dependen del modelo
- Se puede acceder a la marca del coche por su modelo => [SUPRA.marca] devuelve [Marcas.TOYOTA]

- Se debe poder elegir un estado entre NUEVO, USADO, GASTADO
- Se puede acceder al kilometraje del coche por su estado => [NUEVO.kilometraje] devuelve [0] (0, 70.000, 160.000)

- Cada coche tiene un precio base, que depende del modelo (34.000, 14.000, 48.000)
- El estado del coche altera el precio final. ( 100%, 70%, 20%)

*nota: los números en código no tienen punto, es sólo para mejor legibilidad
 */

public class Coche {

	public static void main(String[] args) {
		Coche miCoche = new Coche(Modelos.PASSAT, Estados.NUEVO);
		System.out.println("Tengo un " + miCoche.modelo.marca + " " + miCoche.modelo);
		System.out.println("Está " + miCoche.estado + ", tiene " + miCoche.estado.kilometraje + " kilómetros");
		System.out.println("Te lo vendo por " + (int) (miCoche.modelo.precioBase * miCoche.estado.multiplicadorPrecio) + "€" );
	}

    Coche(Modelos modelo, Estados estado) {
		this.modelo = modelo;
		this.estado = estado;
    }
	
	Modelos modelo;
	enum Modelos {
		SUPRA(Marcas.TOYOTA, 34000),
		IBIZA(Marcas.SEAT, 14000),
		PASSAT(Marcas.VOLKSWAGEN, 48000);
		
		Marcas marca;
		enum Marcas {
			TOYOTA,
			SEAT,
			VOLKSWAGEN
		}

		int precioBase;

        private Modelos(Marcas marca, int precioBase) {
			this.marca = marca;
			this.precioBase = precioBase;
        }
    }

	Estados estado;
	enum Estados {
		NUEVO(0,1f),
		USADO(70000, 0.7f),
		GASTADO(160000, 0.2f);

		int kilometraje;
		float multiplicadorPrecio;
        private Estados(int kilometraje, float multiplicadorPrecio) {
			this.kilometraje = kilometraje;
			this.multiplicadorPrecio = multiplicadorPrecio;
        }		 		
	}
}
