package deque;

public class LinkedListDeque<T> {
    // 定义节点类
    private class Node {
        T item;
        Node next;
        Node prev;

        // 节点构造函数
        Node(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    // 哨兵节点
    private Node sentinel;
    private int size;

    // 构造函数：创建一个空的双端队列
    public LinkedListDeque() {
        sentinel = new Node(null);  // 哨兵节点不存储有效数据
        sentinel.next = sentinel;  // 指向自己，形成循环
        sentinel.prev = sentinel;  // 指向自己，形成循环
        size = 0;
    }

    // 在队列的前端添加元素
    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;  // 更新原队列第一个节点的前驱
        sentinel.next = newNode;  // 更新哨兵节点的下一个节点
        size++;
    }

    // 在队列的后端添加元素
    public void addLast(T item) {
        Node newNode = new Node(item);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;  // 更新原队列最后一个节点的后继
        sentinel.prev = newNode;  // 更新哨兵节点的前驱
        size++;
    }

    // 从队列的前端移除元素并返回该元素
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;  // 更新新的第一个节点的前驱
        size--;
        return firstNode.item;
    }

    // 从队列的后端移除元素并返回该元素
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;  // 更新新的最后一个节点的后继
        size--;
        return lastNode.item;
    }

    // 获取指定索引位置的元素，使用迭代
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    // 获取指定索引位置的元素，使用递归
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    // 返回队列中的元素个数，常数时间
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    // 打印队列中的所有元素
    public void printDeque() {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();  // 打印完毕后换行
    }


}