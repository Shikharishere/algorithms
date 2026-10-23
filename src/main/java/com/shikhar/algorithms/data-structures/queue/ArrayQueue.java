package com.shikhar.algorithms.datastructures.queue;

public class ArrayQueue<T> implements Queue<T> {
    private T[] data;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        front = rear = 0;
        data = (T[]) new Object[capacity];
    }

    public void offer(T element) {
        if(rear == data.length - 1)  {
            throw new RuntimeException("Queue is full");
        }
        data[rear++] = element;
    }

    public T poll() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        T value = data[front];
        data[front++] = null;
        return value;
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return data[front];
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}