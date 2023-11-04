package org.lumijiez.intf;

public interface LumiQueue<E> {
    void enqueue(E item);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
    void clear();
}

