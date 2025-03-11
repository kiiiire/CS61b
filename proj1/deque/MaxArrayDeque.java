package deque;

import deque.ArrayDeque;

import java.util.Iterator;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> implements Iterable<T> {
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> cmp) {
        this.cmp = cmp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }

    public T max() {
        if (isEmpty())
            return null;
        T maxItem = get(0);
        for (T i : this) {
            if (cmp.compare(i, maxItem) > 0)
                maxItem = i;
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty())
            return null;
        T maxItem = get(0);
        for (T i : this) {
            if (c.compare(i, maxItem) > 0)
                maxItem = i;
        }
        return maxItem;
    }
}
