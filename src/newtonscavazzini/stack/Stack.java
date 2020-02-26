package newtonscavazzini.stack;

/**
 * This is a basic implementation of a Stack.
 * The getMin() method here returns in O(n) time.
 */
public class Stack {

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

}
