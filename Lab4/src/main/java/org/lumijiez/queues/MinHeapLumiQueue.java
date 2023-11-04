package org.lumijiez.queues;

import org.lumijiez.intf.LumiQueue;

import java.util.PriorityQueue;
import java.util.NoSuchElementException;

public class MinHeapLumiQueue<E extends Comparable<E>> implements LumiQueue<E> {
    private final PriorityQueue<E> priorityQueue;

    public MinHeapLumiQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void enqueue(E item) {
        priorityQueue.offer(item);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return priorityQueue.poll();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return priorityQueue.peek();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public void clear() {
        priorityQueue.clear();
    }
}
