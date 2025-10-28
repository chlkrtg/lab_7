package ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterator<Integer> {

    private int count;
    private int current;

    public PrimesGenerator (int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }

        this.count = count;
        this.current = 2;
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше нет простых чисел");
        }

        while (!isPrime(current)) {
            current++;
        }

        int prime = current;
        current++;
        count--;

        return prime;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Удаление не поддерживается");
    }
}