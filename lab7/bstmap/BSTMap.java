package bstmap;

import java.util.Set;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;             // root of BST

    private class Node {
        private final K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.left = null;
            this.right = null;
        }
    }

    public BSTMap() {
        root = null;
    }

    @Override
    public void clear() {
        root = null;
    }

    private class ReturnValue {
        private final boolean found;
        private final Node node;

        public ReturnValue(boolean found, Node node) {
            this.found = found;
            this.node = node;
        }

        public boolean getFound() {
            return found;
        }

        public Node getNode() {
            return node;
        }
    }

    private ReturnValue get(Node x, K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return new ReturnValue(false, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return new ReturnValue(true, x);
        }
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        ReturnValue returnValue = get(root, key);
        if (returnValue.getFound()) {
            return returnValue.getNode().val;
        } else {
            return null;
        }
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else return x.size;
    }

    @Override
    public int size() {
        return size(root);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.val = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }
        root = put(root, key, value);
    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    /* An iterator class for BSTMap. */
    private class BSTMapIterator implements Iterator<K> {
        private final Iterator<K> iterator;

        public BSTMapIterator() {
            Set<K> keySet = keySet();
            iterator = keySet.iterator();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public K next() {
            return iterator.next();
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private void printInOrder(Node x) {
        if (x == null) {
            return;
        }
        printInOrder(x.left);
        System.out.println("Key: " + x.key + " | Value: " + x.val);
        printInOrder(x.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }
}