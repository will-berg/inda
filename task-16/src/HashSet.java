import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A hash table-based implementation of the Set interface.
 *
 * @author William Berg
 * @version 2020-02-02
 */
public class HashSet<T> implements Set<T> {
    private List<T>[] table;
    // Capacity of the array
    private int quantity;
    // Number of elements in the hash set.
    private int size;

    public static void main(String[] args) {
        String elem = "255";
        System.out.println((elem.hashCode() & 0x7fffffff)%30);
    }

    /**
     * Creates a hash table with the given capacity (amount of buckets).
     *
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive, non-zero value! Provided: " + capacity);
        }

        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /*
         * This array will contain only LinkedList<T>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
        @SuppressWarnings("unchecked") // for this declaration only
                // This is an array of #capacity linked lists.
                List<T>[] t = new LinkedList[capacity];

        table = t;
        quantity = capacity;

        // Creates a generic linked list for every index in the array.
        for (int i = 0; i < quantity; i++) {
            table[i] = new LinkedList<>();
        }

    }

    /**
     * THIS IS A HASH FUNCTION. Hashes a key to an index value in the array that decides in which linked list
     * to store the key value pair. The integer value that represents the index will be
     * positive thanks to the 0x7fffffff statement.
     *
     * @param key the key to be hashed.
     * @return the index where the linked list will be that stores the key value pair.
     */
    public int hash(T key) {
        return (key.hashCode() & 0x7fffffff) % quantity;
    }

    /**
     * Adds the given element to the set. The element is added to the end
     * of the linked list at the index produced by the hash function (this only
     * happens if the element is not already in the linked list).
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    public boolean add(T elem) {
        if (table[hash(elem)].contains(elem)) {
            return false;
        } else {
            table[hash(elem)].add(elem);
            size++;
            return true;
        }
    }

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    public boolean remove(T elem) {
        if (table[hash(elem)].contains(elem)) {
            table[hash(elem)].remove(elem);
            size--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {
        return table[hash(elem)].contains(elem);
    }

    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    public int size() {
        return size;
    }
}