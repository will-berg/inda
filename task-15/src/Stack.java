public interface Stack<T> {
    /**
     * Adds the element to the top of the stack.
     * @param elem the element to be added
     */
    void push(T elem);

    /**
     * Removes and returns the top element in the stack, that is the element that was
     * last added to the stack (LIFO).
     * @return the removed element
     */
    T pop();

    /**
     * Returns the top element in the stack without removing it.
     * @return the top element
     */
    T top();

    /**
     *
     * @return the number of elements in the stack.
     */
    int size();

    /**
     * Checks if the stack is empty.
     * @return returns true if the stack is empty.
     */
    boolean isEmpty();
}
