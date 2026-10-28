import java.util.Arrays;

public class DynamicArraySorted {
    
    private static final int PREDEFINED_CAPACITY = 7;
    private int[] data;
    private int capacity;
    private int size;

    public DynamicArraySorted(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

/*    public DynamicArraySorted() {
        this.DynamicArraySorted(PREDEFINED_CAPACITY);
    } */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(int element) {
        int index;
        if(size < capacity) {
            index = Arrays.binarySearch(Arrays.copyOf(data, size), element);
            if(index < 0) {
                index = sanitizeIndex(index);
            }
            return insertAt(element, index);
        } else {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
            index = Arrays.binarySearch(Arrays.copyOf(data, size), element);
            if(index < 0) {
                index = sanitizeIndex(index);
            }
            return insertAt(element, index);
        }
    }

    private boolean insertAt(int element, int index) {
        if(index == size) {
            data[index] = element;
        } else if(index > -1 && index < size) {
            System.arraycopy(data, index, data, index + 1, size);
            data[index] = element;
        }
        size++;
        return true;
    }

    public boolean remove(int element) {
        int index = Arrays.binarySearch(data, element);
        return removeAt(element, index);
    }

    private boolean removeAt(int element, int index) {
        if(index < 0 || index >= size) {
            return false;
        }

        System.arraycopy(data, index+1, data, index, size - index - 1);
        size--;
        return true;
    }

    private int sanitizeIndex(int index) {
        return (index + 1) * -1;
    }

    public String toString() {
        if(isEmpty()) return "";
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
        DynamicArraySorted arr = new DynamicArraySorted(10);

        arr.add(-15);
        arr.add(12);
        arr.add(9);
        arr.add(-100); 
        arr.add(0);
        arr.remove(0);
        System.out.println(arr.toString());
    }        
}
