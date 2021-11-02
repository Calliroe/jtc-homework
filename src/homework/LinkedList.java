package homework;

import java.util.*;


public class LinkedList implements List<String> {

    private Element head;
    private Element tail;
    private int size = 0;

    public LinkedList() {
    }

    @Override
    public boolean add(String item) {
        addLast(item);
        return true;
    }

    @Override
    public void add(int index, String item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Element cursor = getElement(index);
            Element newItem = new Element(item);
            cursor.prev.next = newItem;
            newItem.prev = cursor.prev;
            cursor.prev = newItem;
            newItem.next = cursor;
            size++;
        }
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        for (String s : collection) {
            addLast(s);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        for (String s : collection) {
            add(index++, s);
        }
        return true;
    }

    public void addFirst(String item) {
        if (isEmpty()) {
            head = tail = new Element(item);
        } else {
            head.prev = new Element(item);
            head.prev.next = head;
            head = head.prev;
        }
        size++;
    }

    public void addLast(String item) {
        if (isEmpty()) {
            head = tail = new Element(item);
        } else {
            tail.next = new Element(item);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    public boolean checkForAction() {
        if (size == 0) throw new NoElementException();
        return true;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        if (!(obj instanceof String)) return false;
        for (String s : this) {
            if (s.equals(obj)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!contains(obj)) return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof homework.LinkedList)) return false;
        homework.LinkedList list = (homework.LinkedList) obj;
        if (size != list.size) return false;
        if (!(size == 0)) {
            for (Element l = list.head, element = head; ; l = l.next, element = element.next) {
                if (!l.equals(element)) return false;
                if (l.next == null) return true;
            }
        } else return true;
    }

    @Override
    public String get(int index) {
        return getElement(index).data;
    }

    public Element getElement(int index) {
        if (index < 0 || index >= size) throw new NoSuchElementException();
        else {
            int count = 0;
            for (Element element = head; ; element = element.next) {
                if (count++ == index) return element;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 66;
        if (!(size == 0)) {
            for (Element element = head; ; element = element.next) {
                hash += element.hashCode();
                if (element.next == null) return hash;
            }
        } else return hash;
    }

    @Override
    public int indexOf(Object obj) {
        if (!(obj instanceof String)) throw new IllegalArgumentException("Requested type: String");
        if (isEmpty()) throw new NoElementException();
        int index = 0;
        for (String s : this) {
            if (s.equals(obj)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (!(o instanceof String)) throw new IllegalArgumentException("Requested type: String");
        if (isEmpty()) throw new NoElementException();
        int index = size - 1;
        for (Element e = tail; ; e = e.prev) {
            if (e.data.equals(o)) return index;
            if (e.prev != null) index--;
            else return -1;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (checkForAction() && o instanceof String) {
            remove(indexOf(o));
            return true;
        }
        throw new IllegalArgumentException("Requested type: String");
    }

    @Override
    public String remove(int index) {
        Element cursor = getElement(index);
        String s = cursor.data;
        if (size == 1) {
            clear();
            return s;
        }
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
        }
        size--;
        return s;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Element item = head; item != null; item = item.next) {
            if (collection.contains(item.data)) {
                remove(item.data);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (Element item = head; item != null; item = item.next) {
            if (!(collection.contains(item.data))) {
                remove(item.data);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public String set(int index, String item) {
        String s = getElement(index).data;
        getElement(index).data = item;
        return s;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        int count = 0;
        for (String s : this) {
            obj[count++] = s;
        }
        return obj;
    }

    @Override
    public <T> T[] toArray(T[] array) throws IllegalArgumentException {
        if (array.length < size)
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = array;
        for (Element item = head; item != null; item = item.next) result[i++] = item.data;
        if (array.length > size) array[size] = null;
        return array;
    }

    @Override
    public String toString() {
        StringBuilder toStr = new StringBuilder("[");
        for (String s : this) {
            toStr.append(" ").append(s).append(" ");
        }
        toStr.append("]");
        return toStr.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<String> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        if (!(index >= 0 && index <= size)) throw new NullPointerException();
        return new ListItr(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex < size))
            throw new NoSuchElementException("Incorrect indexes");
        homework.LinkedList list = new homework.LinkedList();
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(getElement(i).data);
        }
        return list;
    }

    public static class Element {
        String data;
        Element next;
        Element prev;

        public Element() {
        }

        public Element(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Element)) return false;
            Element element = (Element) o;
            return Objects.equals(data, element.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return data;
        }
    }

    class ListItr implements ListIterator<String> {
        private Element current;
        private Element next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size) ? null : getElement(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = next;
            next = next.next;
            nextIndex++;
            return current.data;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public String previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = next = (next == null) ? tail : next.prev;
            nextIndex--;
            return current.data;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            if (current == null) throw new IllegalStateException();
            Element willNext = current.next;
            homework.LinkedList.this.remove(current);
            if (next == current)
                next = willNext;
            else
                nextIndex--;
            current = null;
        }

        public void set(String e) {
            if (current == null) throw new IllegalStateException();
            current.data = e;
        }

        public void add(String e) {
            current = null;
            if (next == null) homework.LinkedList.this.add(size, e);
            else homework.LinkedList.this.add((nextIndex), e);
            nextIndex++;
        }
    }

}
