public interface Stack<T> {
    public boolean isEmpty();
    
    public int size();

    public T peek();

    public void push(T element);

    public T pop();

    public String toString();
}