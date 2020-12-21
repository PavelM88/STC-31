package part1.lesson12;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialInStream {
    public static BigInteger streamParallel(int num) {
        if (num < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, num)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply).get();
    }

    public static void main(String[] args) {
        int[] numArr = {1, 5, 7, 12};
        for (int num : numArr) {
            System.out.println(streamParallel(num));
        }
    }
}
