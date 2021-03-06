package newtonscavazzini.stack;

import java.util.EmptyStackException;

/**
 * This is the implementation of the special Stack (CC stands for Constant Complexity).
 * All of the methods of this Stack returns in O(1) time.
 */
public class StackCC extends Stack {

    protected Stack minStack;

    public StackCC() {
        this.minStack = new Stack();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(int value) {
        super.push(value);

        if (this.minStack.isEmpty() || value <= this.minStack.peek()) {
            this.minStack.push(value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int pop() {
        int pop = super.pop();

        if (pop == this.minStack.peek()) {
            this.minStack.pop();
        }

        return pop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        this.minStack.clear();
    }

    /**
     * Returns the minimium element on this stack.
     * Time Complexity: O(1)
     * @return The minimum element on this stack
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public int getMin() {
        return this.minStack.peek();
    }
}
