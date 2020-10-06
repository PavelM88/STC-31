package homeWork2.work2_1;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int random = r.nextInt(100) + 1;
            if (random > 0) {
                double q = Math.sqrt(random);
                int q1 = (int) Math.round(q);
                if (q1 == k) {
                    System.out.println(q1);
                }
            } else {
                System.out.println("Числа отрицательные!");
                break;
            }
        }
    }
}
