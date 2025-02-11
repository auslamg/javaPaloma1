package programaMe.vol3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej303 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Node amps = new Node(4);
        amps.L = new Node(5);

        System.out.println(amps.isCorrect());

        /* int in_casos = scn.nextInt();
        scn.nextLine();

        for (int i = 0; i < in_casos; i++) {
            Test(scn.nextInt());
        } */
    }

    private static void Test(int rootVal) {
        Node root = new Node(rootVal);
        

        //TODO
    }

    static ArrayList<Integer> InsertLeft(ArrayList<Integer> list, Integer index) {
        ArrayList<Integer> newList = new ArrayList<>(list);
        for (int i = list.indexOf(index); i < list.size(); i++) {
            newList.set(i+1, list.get(i));
        }
        return list;
    }
}


class Node {
    Node parent;
    boolean isParentLeft;

    int value;
    Node L;
    Node R;

    public boolean isCorrect() {
        boolean isLCorrect = true;
        boolean isRCorrect = true;

        boolean isLParCor = true;
        boolean isRParCor = true;

        isLCorrect = (L != null) ? (L.value < value) : true;
        isRCorrect = (R != null) ? (value < R.value) : true;
        
        if (parent != null) {
            if (isParentLeft) {
                isLParCor = (L.value < parent.value);
            }
            else {
                isRParCor = (R.value < parent.value);
            }
        }        

        return isLCorrect && isRCorrect && isLParCor && isRParCor;
    }

    public Node(int v) {
        this.value = v;
    }
    
}