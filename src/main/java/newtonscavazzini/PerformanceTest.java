package newtonscavazzini;

import newtonscavazzini.stack.Stack;
import newtonscavazzini.stack.StackCC;

public class PerformanceTest {

    public static void main(String[] args) {

        Stack stack = getStackTypeFromArgs(args);
        final int n = getNumberOfElementsFromArgs(args, 10_000_000);

        // Worst-case for memory usage
        for (int i = n; i > 0; i--) {
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

    private static int getNumberOfElementsFromArgs(String[] args, int defaultSize) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].toUpperCase().equals("-N")) {
                    return Integer.parseInt(args[i + 1]);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println(PerformanceTest.class.getSimpleName() +
                    ": Argument after -n must be an integer");
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(PerformanceTest.class.getSimpleName() +
                    ": Missing argument after -n");
            System.exit(1);
        }
        return defaultSize;
    }

    private static Stack getStackTypeFromArgs(String[] args) {
        for (String arg : args) {
            if (arg.toUpperCase().equals("-CC")) {
                return new StackCC();
            }
        }
        return new Stack();
    }
}
