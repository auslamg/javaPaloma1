package apuntesclase.ficheros.ddd_example;

public class Customer extends ValueObject {

    public static void main(String[] args) {

    }

    private final String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;

    public Customer(String DNI, String nombre, String apellido1, String apellido2, String email)
            throws IllegalArgumentException {
        super(DNI);
        if (!DNI.matches("\\d{8}[a-zA-Z]")) {
            throw new IllegalArgumentException("DNI must have 8 numeric characters followed by 1 alphabetic character");
        }
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
    }

    @Override
    public String getValues() {
        return ID + "#" +
            DNI + "," +
            nombre + "," +
            apellido1 + "," +
            apellido2 + "," +
            email;
    }

    public String getDNI() {
        return this.DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (!email.matches(".+@(?:.+\\.)+[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
}