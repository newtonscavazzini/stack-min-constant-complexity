package newtonscavazzini.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a basic implementation of a Stack.
 * The getMin() method here returns in O(n) time.
 */
public class Stack implements Iterable<Integer> {

    protected Node top;
    protected int size;

    /**
     * Pushes an element to the top of the Stack.
     * Time Complexity: O(1)
     * @param value Value to be pushed.
     */
    public void push(int value) {
        Node newNode = new Node(value);

        if (this.top != null) {
            newNode.setNext(this.top);
        }

        this.top = newNode;
        this.size++;
    }

    /**
     * Removes the element at the top of this stack and returns that value.
     * Time Complexity: O(1)
     * @return The removed element
     * @throws EmptyStackException if this stack is empty
     */
    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        int element = this.top.getValue();
        this.top = top.getNext();
        this.size--;

        return element;
    }

    /**
     * Removes all elements of this stack.
     * Time Complexity: O(1)
     */
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Returns the element at the top of this stack without removing it.
     * Time Complexity: O(1)
     * @return The element at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public int peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.getValue();
    }

    /**
     * Returns the minimium element on this stack.
     * Time Complexity: O(n)
     * @return The minimum element on this stack
     * @throws EmptyStackException if this stack is empty
     */
    public int getMin() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        int min = this.top.getValue();

        for (Integer value : this) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Returns the number of elements in this stack.
     * Time Complexity: O(1)
     * @return number of elements in this stack
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns {@code true} if this stack has no elements.
     * {@code false} otherwise.
     * Time Complexity: O(1)
     * @return {@code true} if this stack has no elements.
     *         {@code false} otherwise.
     */
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr(this.top);
    }

    private static class Itr implements Iterator<Integer> {

        Node current;

        public Itr(Node top) {
            current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            int value = current.getValue();
            current = current.getNext();
            return value;
        }

    }

}
