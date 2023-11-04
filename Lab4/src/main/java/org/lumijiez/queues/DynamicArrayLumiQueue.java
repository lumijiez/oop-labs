package org.lumijiez.queues;

import org.lumijiez.intf.LumiQueue;

import java.util.NoSuchElementException;

public class DynamicArrayLumiQueue<E> implements LumiQueue<E> {
    private Object[] array;
    private int size;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArrayLumiQueue() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(E item) {
        ensureCapacity(size + 1);
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = (E) array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[(front + i) % array.length] = null;
        }
        size = 0;
        front = 0;
        rear = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % array.length];
            }
            array = newArray;
            front = 0;
            rear = size;
        }
    }
}
