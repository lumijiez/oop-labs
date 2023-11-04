package org.lumijiez;

import org.lumijiez.intf.LumiQueue;
import org.lumijiez.intf.LumiStack;
import org.lumijiez.queues.DynamicArrayLumiQueue;
import org.lumijiez.queues.LinkedListLumiQueue;
import org.lumijiez.queues.MinHeapLumiQueue;
import org.lumijiez.stacks.ArrayLumiStack;
import org.lumijiez.stacks.DynamicArrayLumiStack;
import org.lumijiez.stacks.LinkedListLumiStack;

public class Main {
    public static void main(String[] args) {
        boolean queueTestsPassed = testQueues();
        boolean stackTestsPassed = testStacks();

        if (queueTestsPassed && stackTestsPassed) {
            System.out.println("All Test OK");
        } else {
            System.out.println("Tests Failed");
        }
    }

    public static boolean testQueues() {
        boolean dynamicArrayTest = true;
        boolean linkedListTest = true;
        boolean minHeapTest = true;

        // Test for Dynamic Array Queue
        LumiQueue<Integer> dynamicArrayQueue = new DynamicArrayLumiQueue<>();
        dynamicArrayQueue.enqueue(1);
        dynamicArrayQueue.enqueue(2);
        dynamicArrayQueue.enqueue(3);
        dynamicArrayTest &= dynamicArrayQueue.size() == 3;
        dynamicArrayTest &= dynamicArrayQueue.peek() == 1;
        dynamicArrayTest &= dynamicArrayQueue.dequeue() == 1;
        dynamicArrayTest &= dynamicArrayQueue.size() == 2;
        dynamicArrayTest &= !dynamicArrayQueue.isEmpty();

        System.out.println((dynamicArrayTest) ? "OK : Dynamic Array Queue Test Passed" : "BAD : Dynamic Array Queue Test Failed");

        // Test for Linked List Queue
        LumiQueue<String> linkedListQueue = new LinkedListLumiQueue<>();
        linkedListQueue.enqueue("Apple");
        linkedListQueue.enqueue("Banana");
        linkedListQueue.enqueue("Cherry");
        linkedListTest &= linkedListQueue.size() == 3;
        linkedListTest &= linkedListQueue.peek().equals("Apple");
        linkedListTest &= linkedListQueue.dequeue().equals("Apple");
        linkedListTest &= linkedListQueue.size() == 2;
        linkedListTest &= !linkedListQueue.isEmpty();

        System.out.println((linkedListTest) ? "OK : Linked List Queue Test Passed" : "BAD : Linked List Queue Test Failed");

        // Test for Priority Queue (Min-Heap) Queue
        LumiQueue<Double> priorityQueueQueue = new MinHeapLumiQueue<>();
        priorityQueueQueue.enqueue(3.2);
        priorityQueueQueue.enqueue(1.5);
        priorityQueueQueue.enqueue(2.1);
        minHeapTest &= priorityQueueQueue.size() == 3;
        minHeapTest &= priorityQueueQueue.peek() == 1.5;
        minHeapTest &= priorityQueueQueue.dequeue() == 1.5;
        minHeapTest &= priorityQueueQueue.size() == 2;
        minHeapTest &= !priorityQueueQueue.isEmpty();

        System.out.println((minHeapTest) ? "OK : MinHeap Queue Test Passed" : "BAD : MinHeap Queue Test Failed");

        return dynamicArrayTest && linkedListTest && minHeapTest;
    }

    public static boolean testStacks() {
        boolean dynamicArrayTest = true;
        boolean linkedListTest = true;
        boolean arrayTest = true;

        // Test for Array Stack
        LumiStack<Integer> arrayStack = new ArrayLumiStack<>();
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayTest &= arrayStack.size() == 3;
        arrayTest &= arrayStack.peek() == 30;
        arrayTest &= arrayStack.pop() == 30;
        arrayTest &= arrayStack.size() == 2;
        arrayTest &= !arrayStack.isEmpty();

        System.out.println((arrayTest) ? "OK : Array Stack Test Passed" : "BAD : Array Stack Test Failed");

        // Test for Linked List Stack
        LumiStack<String> linkedListStack = new LinkedListLumiStack<>();
        linkedListStack.push("First");
        linkedListStack.push("Second");
        linkedListStack.push("Third");
        linkedListTest &= linkedListStack.size() == 3;
        linkedListTest &= linkedListStack.peek().equals("Third");
        linkedListTest &= linkedListStack.pop().equals("Third");
        linkedListTest &= linkedListStack.size() == 2;
        linkedListTest &= !linkedListStack.isEmpty();

        System.out.println((linkedListTest) ? "OK : Linked List Stack Test Passed" : "BAD : Linked List Stack Test Failed");

        // Test for Dynamic Array Stack
        LumiStack<Character> dynamicArrayStack = new DynamicArrayLumiStack<>();
        dynamicArrayStack.push('A');
        dynamicArrayStack.push('B');
        dynamicArrayStack.push('C');
        dynamicArrayTest &= dynamicArrayStack.size() == 3;
        dynamicArrayTest &= dynamicArrayStack.peek() == 'C';
        dynamicArrayTest &= dynamicArrayStack.pop() == 'C';
        dynamicArrayTest &= dynamicArrayStack.size() == 2;
        dynamicArrayTest &= !dynamicArrayStack.isEmpty();

        System.out.println((dynamicArrayTest) ? "OK : Dynamic Array Stack Test Passed" : "BAD : Dynamic Array Stack Test Failed");

        return dynamicArrayTest && linkedListTest && arrayTest;
    }
}