package org.learning.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomCollection<E> implements Collection<E> {
    private E[] elements;
    private int size;

    public CustomCollection() {
        elements = (E[])new Object[10];
        size = 0;
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
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size > elements.length) {
            return false;
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private class CustomIterator implements Iterator<E> {
        int currIdx = 0;

        @Override
        public boolean hasNext() {
            return currIdx < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E element = elements[currIdx];
                currIdx++;
                return element;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public static void main(String[] args) {
        CustomCollection<Integer> integerCustomCollection = new CustomCollection<>();

        integerCustomCollection.add(10);
        integerCustomCollection.add(20);
        integerCustomCollection.add(30);
        integerCustomCollection.add(40);

       Iterator<Integer> integerIterator = integerCustomCollection.iterator();
       while (integerIterator.hasNext()){
           int next = integerIterator.next();
           System.out.println(next);
       }
    }

}
