package juegosclase.econ;

import java.util.HashMap;
import java.util.Map;

public class Ec {
    public static void main(String[] args) {

        Store store = new Store();

        // Declare object instances
        store.AddObject(new Obj("A", 5), 100);
        store.AddObject(new Obj("B", 10), 50);
        store.AddObject(new Obj("C", 20), 200);
        store.AddObject(new Obj("D", 15), 75);
        store.AddObject(new Obj("E", 25), 30);
        store.AddObject(new Obj("F", 35), 60);
        store.AddObject(new Obj("G", 45), 40);

        store.ClientBuysObject("A", 70);

    }

    void Buy(String s, Store store) {

    }
}

class Store {
    int name;

    Map<String, Obj> inventory = new HashMap<>();
    Map<String, Integer> currentValues = new HashMap<>();
    Map<String, Integer> stock = new HashMap<>();

    void AddObject(Obj obj, int amount) {
        String key = obj.getName();

        inventory.putIfAbsent(key, obj);
        currentValues.putIfAbsent(key, obj.getBaseValue());

        if (stock.get(key) != null) {
            stock.put(key, stock.get(key) + amount);
        } else {
            stock.putIfAbsent(obj.getName(), amount);
        }
    }

    void ClientBuysObject(String key, int amount) {
        Obj obj = inventory.get(key);

        if (obj == null) {
            System.out.println("Failed to buy " + amount + " " + key + "(s).");
            System.out.println("Object not in stock error");
            return;
        }

        //Read store data
        int curVal = currentValues.get(key);
        int oldCurVal = curVal;
        int objStock = stock.get(key);

        // No stock left
        if (objStock == 0) {
            System.out.println("Failed to buy " + amount + " " + key + "(s) at " + oldCurVal + " each.");
            System.out.println("No stock left error");
            return;
        }

        // Not enough stock
        else if (objStock - amount < 0) {
            amount = objStock;
            System.out.println("Unsufficient stock warning");
        }

        // Demand rises
        curVal *= Math.pow(1.03, amount);
        if (curVal == oldCurVal) {
            curVal++;
        }
        if (curVal <= obj.getMinValue()) {
            curVal = obj.getMinValue();
        }

        // Set new value and amount
        currentValues.replace(key, curVal);
        int newAmount = objStock - amount;
        stock.replace(key, newAmount);

        // Output result
        System.out.println("Bought " + amount + " " + key + "(s) at " + oldCurVal + " each successfully.");
        System.out.println("There are now " + newAmount + " " + key + "(s) at " + curVal + " each.");
    }

}

class Obj {
    String name;
    int baseValue;
    int minValue = 1;

    Obj(String n, int v) {
        name = n;
        baseValue = v;
    }

    public String getName() {
        return name;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public int getMinValue() {
        return minValue;
    }
}
