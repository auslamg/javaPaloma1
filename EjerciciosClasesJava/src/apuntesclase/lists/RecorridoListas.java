package apuntesclase.lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
 
public class RecorridoListas {
    public static void main(String[] args) {

        List<String> listNom = new ArrayList<>();
 
        //DEBUG: Added to list
        listNom.add("Pepe");
        listNom.add("Mara");
        listNom.add("Juan");
        listNom.add("Alicia");
        
        listNom.size(); //Contar
        listNom.remove(0); //Eliminar
        listNom.contains("Pepe"); //Buscar
        listNom.indexOf("Pepe"); //Buscar posición
        listNom.clear(); //Vaciar
        listNom.isEmpty(); //Está vacía
        listNom.remove("Pepe"); // Eliminar por valor
        listNom.toArray(); //Devolver un array

        //DEBUG: Added to list
        listNom.add("Pepe"); 
        listNom.add("Mara");
        listNom.add("Juan");
        listNom.add("Alicia");

        /* listNom.getFirst();
        listNom.getLast(); */
        listNom.subList(0, listNom.size()); //Sublista
 
        //bucle
        System.out.println("-Bucle");
        for (int i = 0; i < listNom.size(); i++) {
            System.out.println(listNom.get(i));
        }
        
 
        //bucle mejorado
        System.out.println("-Bucle mejorado");
        for (String nombre: listNom) {
            System.out.println(nombre);
        }
 
        //Iterator
        System.out.println("-Iterator");
        Iterator<String> iterator = listNom.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //List Iterator
        System.out.println("-List Iterator");
        ListIterator<String> listIterator = listNom.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
 
        //While
        System.out.println("-While");
        int index = 0 ;
        while (listNom.size()> index) {
            System.out.println(listNom.get(index));
            index++ ;
        }
        
        //forEach
        System.out.println("-ForEach");
        listNom.forEach((String name) -> {
            System.out.println(name);
        });
        
        //forEach2
        System.out.println("-ForEach2");
        listNom.forEach(System.out::println);
        
        //stream
        System.out.println("-stream");
        listNom.stream().forEach((c) -> System.out.println(c));
    }
}