package newtonscavazzini.stack;

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

}
