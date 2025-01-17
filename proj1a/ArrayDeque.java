public class ArrayDeque<T> {
    /**implemetn circur array*/
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 8;
        items = (T[]) new Object[size];
        size  = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }


    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void expand() {
        resize(2 * size);
    }

    private void shrink() {
        resize(items.length / 2);
    }

    public void addFirst(T item) {
        if (isFull()) {
            expand();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (isFull()) {
            expand();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }


    private boolean isFull() {
        return items.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = (nextFirst + 1) % size; i < nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size < items.length >> 2) {
            shrink();
        }

        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T res = items[nextFirst];

        items[nextFirst] = null;
        if (!isEmpty()) {
            size -= 1;
        }

        return res;
    }

    public T removeLast() {
        if (size < items.length >> 2) {
            shrink();
        }

        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T res = items[nextLast];

        items[nextLast] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        return res;
    }

    public T get(int index) {
        return items[(nextFirst + index + 1) % items.length];
    }
}
