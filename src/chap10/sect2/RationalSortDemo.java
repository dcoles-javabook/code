package chap10.sect2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Outputs a sorted list of random rational numbers.
 *
 * @author Drue Coles
 */
public class RationalSortDemo {

    public static void main(String[] args) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        RationalNumber[] rationals = new RationalNumber[5];

        // fill array with random rational numbers (single-digit numerators and denominators)
        for (int i = 0; i < rationals.length; i++) {
            int numerator = rand.nextInt(1, 10);
            int denominator = rand.nextInt(1, 10);
            rationals[i] = new RationalNumber(numerator, denominator);
        }

        Arrays.sort(rationals);

        // print each rational number and its approximate decimal value
        for (RationalNumber num : rationals) {
            System.out.printf("%3s %1.2f%n", num, num.floatValue());
        }
    }
}
