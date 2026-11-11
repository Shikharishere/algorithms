import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T extends Comparable<T>> implements Iterable<T> {
    private static final int PREDEFINED_CAPACITY = 5; 
    private T[] data;
    private int capacity; // physical size
    private int size; // logical size

    public DynamicArray() {
        this(PREDEFINED_CAPACITY);
    }

    public DynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("provided index found out of bound in the current context!");
        return data[index];
    }

    public boolean set(T element, int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("provided index found out of bound in the current context!");
        data[index] = element;
        return true;
    }

    public boolean add(T element) {
        if(size < capacity) {
            data[size] = element;
        } else {
            capacity *= 2;
            T[] resized = (T[]) new Object[capacity];
            for(int i = 0; i < size; i++) {
                resized[i] = data[i];
            }
            resized[size] = element;
            data = resized;
        }
        size++;
        return true;
    }

    public boolean removeAt(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("provided index found out of bound in the current context!");
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return true;
    }

    public boolean remove(int element) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(element)) {
                return removeAt(i);
            }
        }

        return false;
    }

    public void reverse() {
        T temp;
        for(int i = 0; i < size / 2; i++) {
            temp = data[size - i - 1];
            data[size - i - 1] = data[i];
            data[i] = temp;
        }
    }

    public void sort() {
        Arrays.sort(data);
    } 

    public void binarySearch(T element) {
        // will add my binary search code using java's built-in method rn
        Arrays.binarySearch(data, element);
    }

    @Override 
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return data[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("(");
        for(int i = 0; i < size - 1; i++) {
            string.append(data[i]);
            string.append(", ");
        }
        string.append(data[size - 1]);
        string.append(")");

        return string.toString();
    }

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray(1); 

        arr.add(10);
        arr.add(20);
        arr.add(-21);
        arr.remove(-21);


        System.out.println(arr.toString());
        System.out.println(arr.get(1));
        System.out.println("Size: " + arr.size());

        arr.reverse();
        System.out.println(arr.toString());
    }

}
