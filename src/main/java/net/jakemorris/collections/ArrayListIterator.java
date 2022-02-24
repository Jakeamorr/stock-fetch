package net.jakemorris.collections;

import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T> {
    ArrayList<T> arrayList;
    int index = 0;

    public ArrayListIterator(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }
    @Override
    public boolean hasNext() {
        if (index < arrayList.getPosition()) return true;
        return false;
    }

    @Override
    public T next() {
        return arrayList.get(index++);
    }
}
