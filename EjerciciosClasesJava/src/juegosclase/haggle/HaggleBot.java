package juegosclase.haggle;

import java.util.Random;

/**
 * INPUT:
 * int price [50 - 1000]
 * 
 * int attempts [2 - 5]
 * int minMultiplier [1.05 - 1.2]
 * int maxMultiplier [1.3 - 1.8]
 * 
 * minusN(int n)
 * if:
 * price - n > price * minMultiplier
 * &&
 * (100-(n/price))%
 * >true
 * price -= n
 * >false
 * minMultiplier++
 * attempts--
 * 
 * 
 * 
 */
public class HaggleBot {

  int price = 100;

  int attempts;
  float minMultiplier;
  float maxMultiplier;

  public HaggleBot() {
    Random r = new Random();

    attempts = 2 + (int) (Math.random() * ((5 - 2) + 1));

    attempts = r.nextInt(5);
    minMultiplier = r.nextFloat(1.2f);
    maxMultiplier = r.nextFloat(1.8f);

  }

  public static void main(String[] args) {
    try {
      System.out.println(1); // 1
      DiscountMinus(); // 2
    } catch (Exception e) { // 5
      System.out.println("CATCH1"); // 5
    } finally { // 6
      System.out.println("FINALLY1"); // 6
    }
  }

  static void DiscountMinus() throws Exception {
    try {
      System.out.println(2); // 2
      throw new Exception("EXC2");
    } catch (Exception e) { // 3
      System.out.println("CATCH2"); // 3
      throw e;
    } finally { // 4
      System.out.println("FINALLY2"); // 4
    }
  }
}
