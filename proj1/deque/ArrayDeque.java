package deque;

public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8]; // 初始化数组大小为8
        size = 0;
        front = 0;
        back = 0;
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, front, a, 0, size);
        items = a;

        front = 0;
        back = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size++;
    }


    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[back] = item;
        back = (back + 1) % items.length;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        T item = items[front];
        front = (front + 1) % items.length;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;

    }

    // 从队列后端移除元素
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        back = (back - 1 + items.length) % items.length;
        T item = items[back];
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(front + index) % items.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
