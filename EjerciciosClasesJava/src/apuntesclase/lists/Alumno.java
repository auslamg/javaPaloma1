package apuntesclase.lists;

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