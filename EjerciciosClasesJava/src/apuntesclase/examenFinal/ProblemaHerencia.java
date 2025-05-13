package apuntesclase.examenFinal;

public class ProblemaHerencia {

    static class Vehículo {
        Vehículo() {System.out.println("Vehículo creado!");}
        String metodoVehiculo() {return "PadreBehaviour";}
    }

    interface Coloreable {
        String metodoColorear();
    }

    static class Coche extends Vehículo implements Coloreable {
        Coche() {System.out.println("Coche creado!!");}
        String metodoCoche() {return "HijoBehaviour";}
        @Override
        public String metodoColorear() {return "ColoreadoBehaviour";}
    }

    public static void main(String[] args) {
        // Clase padre => Padre()
        Vehículo p = new Vehículo(); 
        // Clase hija, implementa coloreable => Padre(), Hija(args)
        Coche pC = new Coche(); 
        // Interfaz coloreable
        Coloreable c = pC; 
        
        // Resultado => ClassCastException (Downcasting inválido)
        System.out.println( (c = (Coche) p).metodoColorear() ); 
        // Resultado => Ejecución correcta (Upcasting válido)
        System.out.println( (p = (Vehículo) pC).metodoVehiculo() );
        //Resultado => Ejecución correcta (Upcasting válido)
        System.out.println((c = (Coloreable) p).metodoColorear());
    }
}
