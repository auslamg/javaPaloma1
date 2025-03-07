package programaMe.vol7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//DONE 3.07 exTime, 1 submits
public class Ej766 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int horchata = in.nextInt();
            int personas = in.nextInt();
            
            List<Person> list = new ArrayList<>();

            if (horchata <= 0) {
                return;
            }

            for (int i = 0; i < personas; i++) {
                int trabajo = in.nextInt();
                int expect = in.nextInt();

                list.add( new Person(trabajo, expect) );
            }

            Comparator<Person> p = new PersComp();
            Collections.sort(list, p);
            
            int personasServidas = 0;
            for (Person person : list) {
                if (person.expect <= horchata) {
                    horchata -= person.expect;
                    personasServidas++;
                }
                else break;
            }

            System.out.println(personasServidas + " " + horchata);
        }

    }

}

class Person{
    int trabajo;
    int expect;

    public Person(int t, int e) {
        trabajo = t;
        expect = e;
    }
    
}

class PersComp implements Comparator<Person> {
    
    @Override
    public int compare(Person o1, Person o2) {

        if (o1.trabajo < o2.trabajo) {
            return 1;
        }
        else if (o1.trabajo == o2.trabajo) {
            
            if (o1.expect < o2.expect) {
                return -1;
            }
            else if (o1.expect == o2.expect) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else return -1;

    }
}
