package apuntesclase.lists;
import java.util.HashMap;
import java.util.HashSet;

class Alumno {
	private String DNI;
	private String nombre;
	
	Alumno (String pDNI) {
		if (pDNI==null || pDNI=="") {
			throw new IllegalArgumentException("Necesita un DNI");
		}
		this.DNI=pDNI;
	}
	
	Alumno (String pDNI, String pNombre) {
		this(pDNI);
		this.nombre=pNombre;
	}
	
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String pDNI) {
		this.DNI = pDNI;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public int hashCode() {
		return DNI.hashCode();
	}

	public boolean equals(Object obj) {
		boolean sonIguales=true;
		if (this == obj) {
			sonIguales= true;
		}
		Alumno other = (Alumno) obj;
		if (DNI == null) {
			if (other.DNI != null)
				sonIguales= false;
		} else if (!DNI.equals(other.DNI))
			sonIguales= false;
		return sonIguales;
	}
}

public class EjemploColecciones {
	
	public static void ejemploConHashSet() {
		System.out.println("=== Ejemplo con HashSet ===");
		Alumno pepe = new Alumno("1A","Pepe");
		Alumno pepeFalso = new Alumno("1A","PepeFalso");
		Alumno antonio = new Alumno("1B","Antonio");
		
		HashSet<Alumno> coleccionHashSet= new HashSet<>();
		System.out.println("Intentamos meter a pepe");
		coleccionHashSet.add(pepe);
		
		System.out.println("Intentamos meter a pepeFalso");
		coleccionHashSet.add(pepeFalso); //este no entrará ya que tiene el mismo DNI
		
		System.out.println("Intentamos meter a antonio");
		coleccionHashSet.add(antonio);
		
		System.out.println("Hay " + coleccionHashSet.size() + " elementos");

		System.out.println("Recorro la colección:");
		for (Alumno lAlumno: coleccionHashSet) {
			System.out.println("- Nombre: " + lAlumno.getNombre());
	    }
		System.out.println("¿Existe antonio?:" + coleccionHashSet.contains(antonio));

		System.out.println("Eliminamos a antonio");
		coleccionHashSet.remove(antonio);
		
		System.out.println("¿Existe antonio?:" + coleccionHashSet.contains(antonio));
		
		System.out.println("Recorro la colección:");
		for (Alumno lAlumno: coleccionHashSet) {
			System.out.println("- Nombre: " + lAlumno.getNombre());
	    }
	}
	 
	public static void ejemploConHashMap() {
		System.out.println("=== Ejemplo con HashMap ===");
		Alumno pepe = new Alumno("1A","Pepe");
		Alumno pepeFalso = new Alumno("1A","PepeFalso");
		Alumno antonio = new Alumno("1B","Antonio");
		
		HashMap<String,Alumno> coleccionHashMap= new HashMap<>();
		
		System.out.println("Intentamos meter a pepe");
		coleccionHashMap.put(pepe.getDNI(),pepe);
		
		System.out.println("Intentamos meter a pepeFalso");
		coleccionHashMap.put(pepeFalso.getDNI(),pepeFalso); //pepe falso se inserta: machaca a "pepe"
		
		System.out.println("Intentamos meter a antonio");
		coleccionHashMap.put(antonio.getDNI(),antonio);
		
		System.out.println("Hay " + coleccionHashMap.size() + " elementos");
		
		//saco un alumno por el DNI "1A"
		System.out.println("Obtengo el alumno con DNI 1A");
		Alumno alumno = coleccionHashMap.get("1A");
		
		//imprimo sus datos
		System.out.println("Ahora imprimo sus datos: el DNI es " + alumno.getDNI() + " y su nombre es " + alumno.getNombre());
		
		//ahora miramos a ver si existe un alumno con DNI "1B" mirando la clave del HashMap
		System.out.println("¿Existe el DNI 1B mediante la clave (Key)?: " + coleccionHashMap.containsKey("1B"));
		
		//ahora quitamos el alumno con DNI "1B"
		System.out.println("Eliminamos el alumno con DNI 1B");
		Alumno alumnoEliminado=coleccionHashMap.remove("1B");
		System.out.println("El alumno eliminado tenía como nombre: " + alumnoEliminado.getNombre());
		
		//Verificamos que el DNI 1B ya no existe:
		System.out.println("¿Existe el DNI 1B? : " +coleccionHashMap.containsKey("1B"));
		
		System.out.println("Hay " + coleccionHashMap.size() + " elementos");
		
	}

	public static void main(String[] args) {
		ejemploConHashSet();
		ejemploConHashMap();
	}
}