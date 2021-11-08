package homework;

import java.util.*;

public class LinkedList<E> implements List<E> {

    private Element<E> head;
    private Element<E> tail;
    private int size = 0;

    public LinkedList() {
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Element<E> cursor = getElement(index);
            Element<E> newItem = new Element<>(cursor.prev, item, cursor);
            cursor.prev.next = newItem;
            cursor.prev = newItem;
            size++;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            addLast(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        for (E s : collection) {
            add(index++, s);
        }
        return true;
    }

    public void addFirst(E item) {
        if (isEmpty()) {
            head = tail = new Element<>(null, item, null);
        } else {
            head.prev = new Element<>(null, item, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(E item) {
        if (isEmpty()) {
            head = tail = new Element<>(null, item, null);
        } else {
            tail.next = new Element<>(tail, item, null);
            tail = tail.next;
        }
        size++;
    }

    public void checkForAction() {
        if (size == 0) throw new NoElementException();
    }

    @Override
    public void clear() {
        if (size == 0) return;
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        for (E item : this) {
            if (item.equals(obj)) return true;
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
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        LinkedList<?> list = (LinkedList<?>) obj;
        if (size != list.size) return false;
        if (!(size == 0)) {
            for (Element<?> l = list.head, element = head; ; l = l.next, element = element.next) {
                if (!l.element.equals(element.element)) {
                    return false;
                }
                if (l.next == null) return true;
            }
        } else return true;
    }

    @Override
    public E get(int index) {
        return getElement(index).element;
    }

    public Element<E> getElement(int index) {
        checkIndex(index);
        int count = 0;
        for (Element<E> element = head; ; element = element.next) {
            if (count++ == index) return element;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) throw new NoSuchElementException();
    }

    @Override
    public int hashCode() {
        int hash = 66;
        if (!(size == 0)) {
            for (Element<E> element = head; ; element = element.next) {
                hash += element.element.hashCode();
                if (element.next == null) return hash;
            }
        } else return hash;
    }

    @Override
    public int indexOf(Object obj) {
        if (isEmpty()) throw new NoElementException();
        int index = 0;
        for (E t : this) {
            if (t.getClass() != obj.getClass()) throw new IllegalArgumentException();
            if (t.equals(obj)) return index;
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
        if (isEmpty()) throw new NoElementException();
        int index = size - 1;
        for (Element<E> e = tail; ; e = e.prev) {
            if (e.element.equals(o)) return index;
            if (e.prev != null) index--;
            else return -1;
        }
    }

    @Override
    public boolean remove (Object o) {
        checkForAction();
        if (contains(o)) {
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
      Element<E> cursor = getElement(index);
        E e = cursor.element;
        if (size == 1) {
            clear();
            return e;
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
        return e;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Element<E> item = head; item != null; item = item.next) {
            if (collection.contains(item.element)) {
                remove(item.element);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (Element<E> item = head; item != null; item = item.next) {
            if (!(collection.contains(item.element))) {
                remove(item.element);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public E set(int index, E item) {
        E e = getElement(index).element;
        getElement(index).element = item;
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        int count = 0;
        for (E t : this) {
            obj[count++] = t;
        }
        return obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) throws IllegalArgumentException {
        if (array.length < size)
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = array;
        for (Element<E> item = head; item != null; item = item.next) result[i++] = item.element;
        if (array.length > size) array[size] = null;
        return array;
    }

    @Override
    public String toString() {
        StringBuilder toStr = new StringBuilder("[");
        for (E t : this) {
            toStr.append(" ").append(t.toString()).append(" ");
        }
        toStr.append("]");
        return toStr.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (!(index >= 0 && index <= size)) throw new NullPointerException();
        return new ListItr(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex < size))
            throw new NoSuchElementException("Incorrect indexes");
        LinkedList<E> list = new LinkedList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(get(i));
        }
        return list;
    }

    static class Element<T> {
        T element;
        Element<T> next;
        Element<T> prev;

        public Element(Element<T> prev, T element, Element<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    class ListItr implements ListIterator<E> {
        private Element<E> current;
        private Element<E> next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size) ? null : getElement(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = next;
            next = next.next;
            nextIndex++;
            return current.element;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = next = (next == null) ? tail : next.prev;
            nextIndex--;
            return current.element;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            if (current == null) throw new IllegalStateException();
            Element<E> willNext = current.next;
            LinkedList.this.remove(current);
            if (next == current)
                next = willNext;
            else
                nextIndex--;
            current = null;
        }

        public void set(E e) {
            if (current == null) throw new IllegalStateException();
            current.element = e;
        }

        public void add(E e) {
            current = null;
            if (next == null) LinkedList.this.add(size, e);
            else LinkedList.this.add((nextIndex), e);
            nextIndex++;
        }
    }

}
