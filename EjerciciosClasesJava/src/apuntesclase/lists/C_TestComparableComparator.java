package apuntesclase.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CompPeso implements Comparator<Tarta> {

    @Override
    public int compare(Tarta tarta1, Tarta tarta2) {
        return tarta1.getPeso() < tarta2.getPeso() ? -1
                : (tarta1.getPeso() == tarta2.getPeso() ? 0 : 1);
    }
}

class CompChocolate implements Comparator<Tarta> {

    @Override
    public int compare(Tarta tarta1, Tarta tarta2) {
        return tarta1.getPorcentajeChocolate() < tarta2.getPorcentajeChocolate() ? -1
                : (tarta1.getPorcentajeChocolate() == tarta2.getPorcentajeChocolate() ? 0 : 1);
    }
}

class CompPrecio implements Comparator<Tarta> {
    @Override
    public int compare(Tarta tarta1, Tarta tarta2) {
        return tarta1.getPrecio() < tarta2.getPrecio() ? -1
                : (tarta1.getPrecio() == tarta2.getPrecio() ? 0 : 1);
    }
}

@SuppressWarnings("FieldMayBeFinal")
class Tarta implements Comparable<Tarta> {

    private String nombre;
    private double peso;
    private double porcentajeChocolate;
    private double precio;

    Tarta(String nombre, double peso, double porcentajeChocolate, double precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.porcentajeChocolate = porcentajeChocolate;
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public double getPorcentajeChocolate() {
        return porcentajeChocolate;
    }

    public double getPrecio() {
        return precio;
    }

    public int compareTo(Tarta tarta) {
        return this.peso < tarta.getPeso() ? -1
                : (this.peso == tarta.getPeso() ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Tarta [nombre=" + nombre + ", peso=" + peso + ", porcentajeChocolate=" + porcentajeChocolate + ", precio="+ precio + "]";
    }
}

public class C_TestComparableComparator {

    public static void main(String[] args) {
        Tarta tarta1 = new Tarta("Tarta 1", 100, 25, 20);
        Tarta tarta2 = new Tarta("Tarta 2", 20, 80, 30);
        Tarta tarta3 = new Tarta("Tarta 2", 20, 95, 30);
        Tarta tarta4 = new Tarta("Tarta 4", 50, 60, 25);
        Tarta tarta5 = new Tarta("Tarta 5", 75, 40, 15);
        Tarta tarta6 = new Tarta("Tarta 6", 30, 70, 10);
        Tarta tarta7 = new Tarta("Tarta 7", 90, 20, 35);
        Tarta tarta8 = new Tarta("Tarta 8", 10, 50, 5);

        ArrayList<Tarta> aLTarta = new ArrayList<Tarta>();
        aLTarta.add(tarta1);
        aLTarta.add(tarta2);
        aLTarta.add(tarta3);
        aLTarta.add(tarta4);
        aLTarta.add(tarta5);
        aLTarta.add(tarta6);
        aLTarta.add(tarta7);
        aLTarta.add(tarta8);

        // utilizamos Comparable para ordenar
        Collections.sort(aLTarta);
        System.out.println("Sort:");
        System.out.println(aLTarta);
        System.out.println();

        // utilizamos Comparator, ordenando por peso
        Collections.sort(aLTarta, new CompPeso());
        System.out.println("Sort CompPeso:");
        System.out.println(aLTarta);
        System.out.println();

        // utilizamos Comparator, ordenando por % de chocolate
        Collections.sort(aLTarta, new CompChocolate());
        System.out.println("Sort CompChocolate:");
        System.out.println(aLTarta);
        System.out.println();

        // utilizamos Comparator, ordenando por precio
        Collections.sort(aLTarta, new CompPrecio());
        System.out.println("Sort CompPrecio:");
        System.out.println(aLTarta);
        System.out.println();

    }
}
