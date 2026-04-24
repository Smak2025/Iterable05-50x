package ru.gr0550x;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class BoundedUniqueCollection<E> implements Collection<E> {

    private final Object[] elements;
    private int size = 0;

    public BoundedUniqueCollection(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Коллекция не может содержать 0 или менее элементов");
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                @SuppressWarnings("unchecked")
                E value = (E) elements[cursor];
                cursor++;
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        //return Arrays.copyOf((T[])elements, size);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException("Нулевые элементы в коллекции не допускаются");
        if (contains(e)) return false;
        if (size == elements.length)
            throw new IllegalStateException("Коллекция заполнена");
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)){
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (var otherElem: c){
            if (!contains(otherElem)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E otherElem: c){
            if (add(otherElem)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        var changed = false;
        for (Object otherElem: c){
            if (remove(otherElem)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        var changed = false;
        int i = 0;
        while (i < size){
            if (!c.contains(elements[i])) {
                remove(elements[i]);
                changed = true;
            } else i++;
        }
        return changed;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}
