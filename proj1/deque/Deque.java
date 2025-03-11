package deque;

public interface Deque<T> {

    // 添加元素到队头
    void addFirst(T item);

    // 添加元素到队尾
    void addLast(T item);

    // 判断队列是否为空
    default boolean isEmpty() {
        return size() == 0;
    }

    // 获取队列中元素的数量
    int size();

    // 打印队列内容
    void printDeque();

    // 删除并返回队头元素
    T removeFirst();

    // 删除并返回队尾元素
    T removeLast();

    // 根据索引获取队列中的元素
    T get(int index);

    // 默认实现：如果队列为空，返回 true

}
