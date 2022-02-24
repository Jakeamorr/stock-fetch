package net.jakemorris.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private Object[] elements;
    private int position = 0;

    public Object[] getElements() {
        return this.elements;
    }

    public int getPosition() { return this.position; }

    public ArrayList(int listSize) {
        this.elements = new Object[listSize];
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator<T>(this);
    }

    public void add(T element) {
        // Check if the array list is full
        if (position < this.elements.length) {
            this.elements[position] = element;
            position++;
        } else {
            expandArraySize();
            this.add(element);
        }
    }

    public Boolean isIdentical(ArrayList<T> list) {
        for (int i = 0; i < this.position; i++) {
            if (!this.elements[i].equals(list.elements[i])) return false;
        }
        return true;
    }

    // TODO: need to check this logic with custom objects
    //       does the equals use the Object equals since Object type in for loop?
    public boolean contains(T obj) {
        for (Object element : this.elements) {
            if (element != null && obj.equals(element)) return true;
        }
        return false;
    }

    // TODO: figure out how to handle unchecked cast
    public T get(int pos) throws NoSuchElementException {
        if (pos >= 0 && pos < this.elements.length) {
            return (T) this.elements[pos];
        } else {
            throw new NoSuchElementException();
        }
    }

    public void setElement(int pos, T obj) throws IllegalArgumentException {
        if (pos >= 0 && pos < this.elements.length - 1) {
            this.elements[pos] = obj;
        } else {
            throw new IllegalArgumentException("Insertion index must be a positive number that is within the bounds of the array");
        }
    }

    public void printElements() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.position - 1; i++) {
            sb.append(this.elements[i] + ", ");
        }
        sb.append(this.elements[this.position - 1]);
        System.out.println("Array contents: " + sb + " ]");
    }

    public int getArraySize() {
        return this.elements.length;
    }

    private void expandArraySize() {
        // double the size of the current array
        int size = this.elements.length * 2;
        Object[] tempArr = new Object[size];
        // Loop over old array and add the contents to the new array
        for (int i = 0; i < this.elements.length; i++) {
            tempArr[i] = this.elements[i];
        }
        this.elements = tempArr;
    }

}

