import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private T data;
        private Node prev;
        private Node next;

        public Node(T element, Node prev, Node next) {
            this.data = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.prev = current.next = null;
            current.data = null;
            current = next; 
        }
        head = tail = null;
        size = 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        if(element == null) throw new IllegalArgumentException("Null elements are't allowed.");
        if(isEmpty()) {
            head = tail = new Node(element, null, null);
        } else {
            tail.next = new Node(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T element) {
        if(element == null) throw new IllegalArgumentException("Null elements aren't allowed.");
        if(isEmpty()) {
            head = tail = new Node(element, null, null);
        } else {
            head.prev = new Node(element, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(T element, int index) {
        if(element == null) throw new IllegalArgumentException("Null elements aren't allowed.");
        if(index < 0 && index > size) throw new IndexOutOfBoundsException("Self explanatory.");

        if(index == 0) {
            addFirst(element);
        } else if(index == size) {
            addLast(element);
        } else {
            Node current = head;
            int currIndex = 0;

            while(currIndex < index - 1) {
                current = current.next;
                currIndex++;
            }

            Node next = current.next;
            current.next = new Node(element, current, current.next);
            next.prev = current.next;
            size++;
        }
    }

    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        return tail.data;
    }

    public boolean removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        Node next = head.next;

        head.next = null;
        head.data = null;

        head = next;
        
        if(isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;

        return true;
    }

    public boolean removeLast() {
        if(isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        Node prev = tail.prev;

        tail.prev = null;
        tail.data = null;

        tail = prev;
        
        if(isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;

        return true;
    }

    public boolean remove(Node node) {
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.data = null;
        node.next = node.prev = null;

        size--;

        return true;
    }

    public boolean removeAt(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of bounds yawr");
        }

        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return remove(current);
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);

        if(index == -1) return false;
        return removeAt(index);

    }

    public int indexOf(Object obj) {
        int index = 0;
        for(Node current = head; current != null; current = current.next, index++) {
            if(obj.equals(current.data)) {
                return index;
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node iter = head;
            @Override
            public boolean hasNext() {
                return iter.next != null;
            }

            @Override
            public T next() {
                T data = iter.data;
                iter = iter.next;
                return data; 
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("(null) <--> ");

        for(Node current = head; current != null; current = current.next) {
            string.append(current.toString());
            string.append(" <--> ");
        }
        string.append("(null)");

        return string.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList();

        list.add(1);
        list.add(12);

        System.out.println(list.toString());
    }
}