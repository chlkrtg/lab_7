package ex2;

import java.util.*;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;

        System.out.println("\nГенерация первых " + N + " простых чисел:");

        PrimesGenerator generator = new PrimesGenerator(N);

        List<Integer> primes = new ArrayList<>();
        while (generator.hasNext()) {
            primes.add(generator.next());
        }

        System.out.println("Прямой порядок:");
        System.out.println(primes);

        System.out.println("\nОбратный порядок:");
        List<Integer> reversed = new ArrayList<>(primes);
        Collections.sort(reversed, Collections.reverseOrder());
        System.out.println(reversed);

        System.out.println("Всего сгенерировано: " + primes.size() + " простых чисел");
        System.out.println("Первое простое число: " + primes.get(0));
        System.out.println("Последнее простое число: " + primes.get(primes.size() - 1));
    }
}