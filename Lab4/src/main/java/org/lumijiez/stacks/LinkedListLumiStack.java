package org.lumijiez.stacks;

import org.lumijiez.intf.LumiStack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListLumiStack<E> implements LumiStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void push(E item) {
        list.addFirst(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }
}
