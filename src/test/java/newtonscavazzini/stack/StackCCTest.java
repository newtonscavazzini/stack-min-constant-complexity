package newtonscavazzini.stack;

import org.junit.jupiter.api.BeforeEach;

class StackCCTest extends StackTest {

    @BeforeEach
    void setUp() {
        super.stack = new StackCC();
    }

}