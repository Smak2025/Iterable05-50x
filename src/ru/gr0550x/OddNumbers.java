package ru.gr0550x;

import java.util.Iterator;

public class OddNumbers implements Iterable<Integer>{

    private final int count;
    public OddNumbers(int count){
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new OddIterator(count);
    }
}
