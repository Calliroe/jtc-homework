package dataStructures;

import java.util.Objects;

public class HashMap {

    private int capacity = 16;
    private Node[] entry = new Node[capacity];
    private static final double LOAD_FACTOR = 0.75;
    private int filling = 0;
    private int size = 0;

    HashMap() {
    }

    HashMap(int capacity) {
        this.capacity = capacity;
        entry = new Node[capacity];
    }

    public void add(String key, String value) {
        Node newElement = new Node(key, value);
        int bucketNumber = bucketNumber(newElement.key.hashCode());
        if (entry[bucketNumber] == null) {
            entry[bucketNumber] = newElement;
            size++;
            if (++filling >= (capacity * LOAD_FACTOR)) {
                redistribution();
            }
        } else {
            for (Node i = entry[bucketNumber]; ; i = i.next) {
                if (newElement.key.equals(i.key)) {
                    i.value = newElement.value;
                    return;
                }
                if (i.next == null) {
                    i.next = newElement;
                    size++;
                    return;
                }
            }
        }
    }

    public void addAll(HashMap map) {
        for (int i = 0; i < map.capacity; i++) {
            if (map.entry[i] != null) {
                add(map.entry[i].key, map.entry[i].value);
                for (Node j = map.entry[i]; j.next != null; j = j.next) {
                    add(j.next.key, j.next.value);
                }
            }
        }
    }

    private int bucketNumber(int hash) {
        return (capacity - 1) & hash;
    }

    public void clear() {
        capacity = 16;
        entry = new Node[capacity];
        filling = 0;
        size = 0;
    }

    public boolean contains(String key) {
        int numForSearch = bucketNumber(key.hashCode());
        if (entry[numForSearch] == null) return false;
        if (entry[numForSearch].key.equals(key)) return true;
        for (Node i = entry[numForSearch]; i.next != null; i = i.next) {
            if (i.next.key.equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashMap)) return false;
        HashMap hashMap = (HashMap) o;
        if (!(getCapacity() == hashMap.getCapacity() && filling == hashMap.filling)) return false;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i] != hashMap.entry[i]) return false;
            if (entry[i] != null) {
                for (Node j = entry[i], k = hashMap.entry[i]; j.next != null && k.next != null; j = j.next, k = k.next) {
                    if (!(j.next.equals(k.next))) return false;
                }
            }
        }
        return true;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFilling() {
        return filling;
    }

    public double getLoadFactor() {
        return LOAD_FACTOR;
    }

    public String getValue(String key) {
        int numForSearch = bucketNumber(key.hashCode());
        if (entry[numForSearch] == null) throw new KeyNotFoundException();
        if (entry[numForSearch].key.equals(key)) return entry[numForSearch].value;
        for (Node i = entry[numForSearch]; i.next != null; i = i.next) {
            if (i.next.key.equals(key)) {
                return entry[numForSearch].value;
            }
        }
        throw new KeyNotFoundException();
    }

    @Override
    public int hashCode() {
        int hash = getCapacity() + filling;
        for (Node n : entry) {
            if (n != null) {
                hash += n.hashCode();
                for (Node i = n; i.next != null; i = i.next) {
                    hash += i.next.hashCode();
                }
            }
        }
        return hash;
    }

    private void redistribution() {
        int newCapacity = capacity * 2;
        HashMap newMap = new HashMap(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if (entry[i] != null) {
                Node j = entry[i];
                do {
                    newMap.add(j.key, j.value);
                    j = j.next;
                } while (j != null);
            }
        }
        capacity = newMap.capacity;
        entry = newMap.entry;
        filling = newMap.filling;
        size = newMap.size;
    }

    public boolean remove(String key) {
        int numForSearch = bucketNumber(key.hashCode());
        if (entry[numForSearch] == null) return false;
        if (entry[numForSearch].key.equals(key)) {
            if (entry[numForSearch].next != null) entry[numForSearch] = entry[numForSearch].next;
            else entry[numForSearch] = null;
            return true;
        }
        for (Node i = entry[numForSearch]; i.next != null; i = i.next) {
            if (i.next.key.equals(key)) {
                if (i.next.next != null) {
                    i.next = i.next.next;
                    return true;
                } else {
                    i.next = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < capacity; i++) {
            if (entry[i] != null) {
                Node j = entry[i];
                do {
                    str.append("[").append(j.toString()).append("] ");
                    j = j.next;
                } while (j != null);
            }
        }
        str.append(" ]");
        return str.toString();
    }

    public static class Node {
        String key;
        String value;
        Node next;

        public Node() {
        }

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

}
