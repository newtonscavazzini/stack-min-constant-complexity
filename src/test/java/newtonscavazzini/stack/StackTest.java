package newtonscavazzini.stack;

import newtonscavazzini.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    protected Stack stack;

    @BeforeEach
    void setUp() {
        this.stack = new Stack();
    }

    @Test
    void shouldPushElements() {
        final int value = 10;
        this.stack.push(value);

        assertEquals(1, this.stack.getSize());
        assertFalse(this.stack.isEmpty());
    }

    @Test
    void shouldPopElements() {
        final int value = 10;

        this.stack.push(value);
        int pop = this.stack.pop();

        assertEquals(value, pop);
        assertEquals(0, this.stack.getSize());
        assertTrue(this.stack.isEmpty());
    }

    @Test
    void shouldPeekTopWithoutRemovingIt() {
        int value = 10;
        this.stack.push(value);

        assertEquals(value, this.stack.peek());
        assertEquals(1, this.stack.getSize());
    }

    @Test
    void shouldClearAllElements() {
        final int n = 10;

        for (int i = 0; i < n; i++) {
            this.stack.push(i);
        }
        this.stack.clear();

        assertEquals(0, this.stack.getSize());
        assertTrue(this.stack.isEmpty());
    }

    @Test
    void shouldGetMinimum() {
        this.stack.push(10);
        this.stack.push(5);
        this.stack.push(15);
        this.stack.push(3);
        this.stack.pop();

        assertEquals(5, this.stack.getMin());
    }

    @Test
    void shouldIterateThrough() {

        final int n = 10;
        for (int i = 0; i < n; i++) {
            this.stack.push(i);
        }

        int count = n - 1;
        for (Integer value : this.stack) {
            assertEquals(count, value);
            count--;
        }
    }

    @Test
    void shouldThrowExceptionWhenPopEmptyStack() {
        assertThrows(EmptyStackException.class, () -> this.stack.pop());
    }

    @Test
    void shouldThrowExceptionWhenPeekEmptyStack() {
        assertThrows(EmptyStackException.class, () -> this.stack.peek());
    }

    @Test
    void shouldThrowExceptionWhenGetMinimumEmptyStack() {
        assertThrows(EmptyStackException.class, () -> this.stack.getMin());
    }

    @Test
    void shouldThrowExceptionWhenCallNextOnIteratorWithEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> this.stack.iterator().next());
    }

}