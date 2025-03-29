package bstmap;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return getHelper(root, key);
    }

    private V getHelper(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return getHelper(node.left, key);
        else if (cmp > 0) return getHelper(node.right, key);
        else return node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }

    private Node putHelper(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = putHelper(node.left, key, value);
        else if (cmp > 0) node.right = putHelper(node.right, key, value);
        else node.value = value;
        return node;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        addKeys(root, keySet);
        return keySet;
    }

    private void addKeys(Node node, Set<K> set) {
        if (node == null) return;
        set.add(node.key);
        addKeys(node.left, set);
        addKeys(node.right, set);
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("remove not implemented");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("remove(key, value) not implemented");
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
