package net.jakemorris.collections;

public interface List<T> extends Iterable<T> {
    void add(T obj);
    boolean contains(T obj);
    T get(int index);
}
