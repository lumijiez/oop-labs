package org.lumijiez.queues;

import org.lumijiez.intf.LumiQueue;

import java.util.NoSuchElementException;

public class LinkedListLumiQueue<E> implements LumiQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListLumiQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
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
        front = null;
        rear = null;
        size = 0;
    }
}

