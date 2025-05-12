package apuntesclase.colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MainListaEnlazadaEnteros {

    public static void main(String[] args) {
        LinkList<Integer> li = new LinkList<>();
        for (int i = 1; i <= 12; i++) {
            li.addNodeLast(i);
        }

        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.getNodeByIndexDescending(i).data);
        }
    }
}

class Node<T extends Object> {

    T data;
    Node<T> previous;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public boolean equals(Node<T> n) {
        return this.data.equals(n.data);
    }
}

class LinkList<E extends Object> implements List<E> {

    private int size = 0;
    Node<E> first = null;
    Node<E> last = null;

    public Node<E> getFirstNode() {
        return first;
    }

    public Node<E> getLastNode() {
        return last;
    }

    public Node<E> getNodeByMatchAscending(Object value) {
        Node<E> currentNode = first;
        boolean foundNode = false;

        // Search all nodes starting from first
        while (!foundNode) {
            // No nodes left
            if (currentNode == null) {
                return null;
            }
            // Match
            if (currentNode.data.equals(value)) {
                return currentNode;
            }
            // Check next
            currentNode = currentNode.next;
        }
        // To avoid compiler error
        return null;
    }

    public Node<E> getNodeByMatchAscending(Node<E> n) {
        Node<E> currentNode = first;
        boolean foundNode = false;

        while (!foundNode) {
            // No nodes left
            if (currentNode == null) {
                return null;
            }
            // Match
            if (currentNode.equals(n)) {
                return currentNode;
            }
            // Check next
            currentNode = currentNode.next;
        }

        return null;
    }

    public Node<E> getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2) {
            return getNodeByIndexAscending(index);
        } else {
            return getNodeByIndexDescending(index);
        }
    }

    Node<E> getNodeByIndexAscending(int index) throws IndexOutOfBoundsException {
        Node<E> currentNode = first;
        boolean foundNode = false;

        int i = 0;
        while (!foundNode) {
            // No nodes left
            if (currentNode == null || i > size) {
                throw new IndexOutOfBoundsException();
            }
            // Match
            if (i == index) {
                return currentNode;
            }
            // Check next
            currentNode = currentNode.next;
            i++;
        }

        return null;
    }

    Node<E> getNodeByIndexDescending(int index) throws IndexOutOfBoundsException {
        Node<E> currentNode = last;
        boolean foundNode = false;

        int i = size - 1;
        while (!foundNode) {
            // No nodes left
            if (currentNode == null || i < 0) {
                throw new IndexOutOfBoundsException();
            }
            // Match
            if (i == index) {
                return currentNode;
            }
            // Check next
            currentNode = currentNode.previous;
            i--;
        }

        return null;
    }

    public int indexOf(Node<E> n) throws NoSuchElementException {
        Node<E> currentNode = first;
        boolean foundNode = false;

        int i = 0;
        while (!foundNode) {
            // No nodes left
            if (currentNode == null) {
                throw new NoSuchElementException("Element is not inside the linked list");
            }
            // Match
            if (currentNode.equals(n)) {
                return i;
            }
            // Check next
            currentNode = currentNode.next;
            i++;
        }
        throw new NoSuchElementException();
    }

    public void addNodeFirst(E value) {
        addNodeFirst(new Node<>(value));
    }

    public void addNodeFirst(Node<E> newNode) {
        // Si no hay primero
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        // Si hay primero
        else {
            // Set new node as previous of old
            first.previous = newNode;
            newNode.next = first;
            // Set first as new node
            first = newNode;
        }
        size++;
    }

    public void addNodeLast(E value) {
        addNodeLast(new Node<>(value));
    }

    public void addNodeLast(Node<E> newNode) {

        // Si no hay primero
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        // Si hay
        else {
            // Set nodes for new node
            newNode.previous = last;
            // Set nodes for old nodes
            last.next = newNode;
            // Set last as new node
            last = newNode;
        }
        size++;
    }

    public void removeNode(Node<E> n) {
        Node<E> replacer = n.next;

        // Set nodes for old nodes
        if (n.previous != null) {
            n.previous.next = replacer;
        }
        if (replacer != null) {
            replacer.previous = n.previous;
        }

        // Set first if removing first
        if (n == first) {
            first = replacer;
        }
        // Decrease list size
        size--;
    }

    public void insertNodeAt(Node<E> newNode, int index) throws IndexOutOfBoundsException {
        // If last index
        if (index == size) {
            addNodeLast(newNode);
            return;
        }

        Node<E> oldNode = getNodeByIndex(index);

        // Set nodes for new node
        newNode.previous = oldNode.previous;
        newNode.next = oldNode;
        // Set new node as next and previous
        newNode.previous.next = newNode;
        oldNode.previous = newNode;
        // Increase list size
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public boolean contains(Object o) {
        return getNodeByMatchAscending(o).equals(o);
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = getNodeByIndex(i).data;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(E e) {
        try {
            addNodeLast(e);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        /*
         * try {
         * removeNode();
         * return true;
         * } catch (Exception ex) {
         * return false;
         * };
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
