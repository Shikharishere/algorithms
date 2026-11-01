import java.util.ArrayList;
import java.util.List;

/**
 * PQueue
 */

public class PQueue<T extends Comparable> {
    private List<T> heap;

    public PQueue() {
        heap = new ArrayList<T>();
    }

    public PQueue(T element) {
        this.PQueue();
        heap.add(element);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        heap.clear();
    }

    public T peek() {
        if(isEmpty()) return null;
        return list.get(0);
    }

    public void add(T element) {
        if(element == null) {
            throw new IllegalArgumentException("Null element input :(");
        }
        heap.add(element);
        swim(size() - 1);
    }

    public void remove(T element) {
        if(!contains(element)) {
            throw new Exception("Given value does not exist :((");
        }
        int index = search(element);

        // swap with the leftmost leaf node
        swap(index, size() - 1);

        heap.remove(size() - 1);

        sink(index);

        if(heap.get(i).equals(element)) {
            swim(i);
        }
    }

    public boolean contains(T element) {
        if(element == null) return false;
        return search(element) != -1;
    }

    private int search(T element) {
        int index = 0;
        for(T temp : heap) {
            if(temp.compareTo(element) == 0) {
                return index;
            }
            index++;
        }

        return -1;
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;

        if(index < 0 || less(parent, index)) {
            return;
        }

        swap(parent, index);
        swim(parent);
    } 

    private void sink(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left >= size() || (less(index, right) && less(index, left))) {
            return;
        }

        if(right < size() && less(right, left)) {
            swap(index, right);
            sink(right);
        } else {
            swap(index, left);
            sink(left);
        }
    }

    private void swap(int i, int j) {
        T one = list.get(i);
        T two = list.get(j);
        heap.set(i, two);
        heap.set(j, one);
    }

    private boolean less(int i, int j) {
        T one = list.get(i);
        T two = list.get(j);

        return one.compareTo(two) <= 0;
    }
}