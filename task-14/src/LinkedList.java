import java.util.NoSuchElementException;

/**
 * A singly linked list.
 *
 * @author (William Berg)
 * @version (2020-01-21)
 */
public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> newFirst = new ListElement<>(element);
        if (isEmpty()) {
            first = newFirst;
            last = newFirst;
        }
        newFirst.next = first;
        first = newFirst;
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> newLast = new ListElement<>(element);
        if (isEmpty()) {
            first = newLast;
            last = newLast;
        }
            last.next = newLast;
            last = newLast;
            size++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.data;
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return last.data;
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if (index >= size || index < 0 || isEmpty()) throw new IndexOutOfBoundsException();
        ListElement<T> currentElement = first;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.data;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (size == 1) {
            last = null;
        }
        ListElement<T> temp = first;
        first = first.next;
        size--;
        return temp.data;
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        while (size != 0) {
            removeFirst();
        }
        first = null;
        last = null;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     * <p>
     * Examples:
     * "[1, 4, 2, 3, 44]"
     * "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder s = new StringBuilder("[");
        ListElement currentElement = first;
        while (currentElement != null) {
            if (currentElement == last) s.append(currentElement.data).append("]");
            else s.append(currentElement.data).append(", ");
            currentElement = currentElement.next;
        }
        return s.toString();
    }
}
