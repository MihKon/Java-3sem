package pract25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashTable<K, V> implements HashMapInterface<K, V> {
    private final int size = 32;
    private final ArrayList<Connection<K, V>>[] lists = new ArrayList[size];

    public MyHashTable() {
        for (int i = 0; i < size; i++) {
            lists[i] = new ArrayList<>();
        }
    }

    public int hash(K key) {
        return key.hashCode() % size;
    }

    @Override
    public void add(K key, V value) {
        int i = hash(key);
        if (lists[i].size() == 0) {
            lists[i].add(new Connection<K, V>(key, value));
        } else {
            boolean f = false;
            for (Connection<K, V> c : lists[i]) {
                if (c.getKey().equals(key)) {
                    c.setValue(value);
                    f = true;
                    break;
                }
            }
            if (!f) {
                Connection<K, V> con = new Connection<K, V>(key, value);
                lists[i].add(con);
                //int j = lists[i].indexOf(con)-1;
                //lists[i].get(j).setNext(con);
            }
        }
    }

    @Override
    public V get(K key) {
        int i = hash(key);
        for (Connection<K, V> c : lists[i]) {
            if (c.getKey().equals(key))
                return c.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int i = hash(key);
        for (Connection<K, V> c : lists[i]) {
            if (c.getKey().equals(key)) {
                Connection<K, V> connection = c;
                //int j = lists[i].indexOf(c)-1;
                lists[i].remove(c);
                //lists[i].get(j).setNext(null);
                return connection.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new MyIterator(this);
    }

    private class MyIterator implements Iterator<V> {
        private MyHashTable<K, V> table;
        int ArrayIndex = 0, index = 0;

        public MyIterator(MyHashTable<K, V> table) {
            this.table = table;
        }

        @Override
        public boolean hasNext() {
            if (ArrayIndex < size) {
                if (index == lists[ArrayIndex].size()) {
                    index = 0;
                    ArrayIndex++;
                    while (ArrayIndex < size && lists[ArrayIndex].size() == 0)
                        ArrayIndex++;
                    return ArrayIndex != size;
                }
                return true;
            }
            else
                return false;
        }

        @Override
        public V next() {
            V value = lists[ArrayIndex].get(index).getValue();
            index++;
            return value;
        }
    }
}
