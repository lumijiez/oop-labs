package org.lumijiez.intf;

public interface LumiStack<E> {

    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
    void clear();
}
