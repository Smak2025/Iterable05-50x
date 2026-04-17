package ru.gr0550x;

import java.util.Iterator;

public class OddIterator implements Iterator<Integer> {

    private int current = 1;

    //Количество нечетных чисел в последовательности
    private final int count;
    public OddIterator(int count){
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return (current + 1) / 2 <= count;
    }

    @Override
    public Integer next() {
        int value = current;
        current += 2;
        return value;
    }
}
