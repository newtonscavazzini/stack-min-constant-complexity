package newtonscavazzini;

import newtonscavazzini.stack.Stack;
import newtonscavazzini.stack.StackCC;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {

        Stack stack = getStackTypeFromArgs(args);
        final int n = getNumberOfElementsFromArgs(args, 10_000_000);
        final int iterations = getNumberOfIterationsFromArgs(args, 1);

        // Worst-case for memory usage
        for (int i = n; i > 0; i--) {
            stack.push(i);
        }

        List<Long> results = new ArrayList<>();
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < iterations; i++) {

            long start = System.nanoTime();
            minimum = stack.getMin();
            long stop = System.nanoTime();

            results.add((stop - start) / 1000);
        }

        long avgExecutionTime = (long) results.stream()
                .mapToLong(l -> l)
                .average()
                .orElseThrow(RuntimeException::new);

        long memoryUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000;
        System.out.println("------------------------------------");
        System.out.println(stack.getClass().getName());
        System.out.println("Elements:        " + stack.getSize());
        System.out.println("Minimum:         " + minimum);
        System.out.println("Iterations:      " + iterations);
        System.out.println("Memory Usage:    " + memoryUsage + "MB");
        System.out.println("getMin() Time:   " + avgExecutionTime + "µs");
        System.out.println("------------------------------------");

    }

    private static int getKeyValueArgument(String[] args, String key, int defaultValue) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].toUpperCase().equals(key)) {
                    return Integer.parseInt(args[i + 1]);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println(PerformanceTest.class.getSimpleName() +
                    ": Argument after " + key + " must be an integer");
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(PerformanceTest.class.getSimpleName() +
                    ": Missing argument after " + key);
            System.exit(1);
        }
        return defaultValue;
    }

    private static int getNumberOfElementsFromArgs(String[] args, int defaultSize) {
        return getKeyValueArgument(args, "-N", defaultSize);
    }

    private static int getNumberOfIterationsFromArgs(String[] args, int defaultSize) {
        return getKeyValueArgument(args, "-I", defaultSize);
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
