package ru.gr0550x;

import java.util.Iterator;

public class EvenNumbers implements Iterable<Integer>{

    private final int count;
    public EvenNumbers(int count){
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current / 2 + 1 <= count;
            }

            @Override
            public Integer next() {
                int value = current;
                current += 2;
                return value;
            }
        };
    }
}
