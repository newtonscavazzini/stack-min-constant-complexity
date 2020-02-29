package newtonscavazzini;

import newtonscavazzini.stack.Stack;
import newtonscavazzini.stack.StackCC;

public class PerformanceTest {

    public static void main(String[] args) {

        Stack stack = new StackCC();

        // Worst-case for memory usage
        for (int i = 10_000_000; i > 0; i--) {
            stack.push(i);
        }

        long start = System.nanoTime();
        int minimum = stack.getMin();
        long stop = System.nanoTime();

        long executionTime = (stop - start) / 1000;
        long memoryUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000;
        System.out.println("------------------------------------");
        System.out.println(stack.getClass().getName());
        System.out.println("Elements:        " + stack.getSize());
        System.out.println("Minimum:         " + minimum);
        System.out.println("Memory Usage:    " + memoryUsage + "MB");
        System.out.println("getMin() Time:   " + executionTime + "µs");
        System.out.println("------------------------------------");

    }
}
