import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private T[] data;
    private int size; // logical size
    private int capacity; // physical size

    public ArrayStack() {
        capacity = 16;
        data = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public void push(T element) {
        if(size == capacity) {
            resize();
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T value = data[size - 1];
        size--;
        data[size] = null;
        return value;
    }

    private void resize() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < size; i++) {
            str.append(data[i].toString());
            str.append("\n--\n");
        }
        return str.toString();
    }
    
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack();
        stack.push(12);
        stack.push(1111);
        stack.push(11);
        stack.push(179);
        stack.push(189);
        stack.push(190);
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }
}