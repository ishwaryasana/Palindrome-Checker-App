import java.util.*;

public class UC13_PalindromeApp {

    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class TwoPointerStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            int left = 0, right = input.length() - 1;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            StringBuilder reversed = new StringBuilder();

            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return input.equals(reversed.toString());
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                deque.add(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    static class RecursiveStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            return checkRecursive(input, 0, input.length() - 1);
        }

        private boolean checkRecursive(String s, int start, int end) {
            if (start >= end) {
                return true;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            return checkRecursive(s, start + 1, end - 1);
        }
    }

    static class StringBuilderStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            String reversed = new StringBuilder(input).reverse().toString();
            return input.equals(reversed);
        }
    }

    public static void main(String[] args) {

        List<PalindromeStrategy> strategies = Arrays.asList(
                new TwoPointerStrategy(),
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy(),
                new StringBuilderStrategy()
        );

        String[] testCases = {
                "a",
                "racecar",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"
        };

        System.out.println("Performance Comparison (time in nanoseconds)");
        System.out.println("=============================================");

        for (String test : testCases) {

            System.out.println("\nTest String: \"" + test + "\" (length: " + test.length() + ")");
            System.out.println("---------------------------------------------");

            for (PalindromeStrategy strategy : strategies) {

                long startTime = System.nanoTime();

                boolean result = strategy.check(test);

                long endTime = System.nanoTime();

                long duration = endTime - startTime;

                String strategyName = strategy.getClass().getSimpleName();

                System.out.printf("%-20s: %10d ns, Result: %b%n",
                        strategyName, duration, result);
            }
        }
    }
}