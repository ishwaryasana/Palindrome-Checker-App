interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
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

class TwoPointerStrategy implements PalindromeStrategy {
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

public class UC12_PalindromeApp {

    private PalindromeStrategy strategy;

    public UC12_PalindromeApp(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }

    public static void main(String[] args) {

        UC12_PalindromeApp app =
                new UC12_PalindromeApp(new TwoPointerStrategy());

        String test = "racecar";

        System.out.println("Using TwoPointerStrategy: " +
                app.checkPalindrome(test));

        app.setStrategy(new StackStrategy());
        System.out.println("Using StackStrategy: " +
                app.checkPalindrome(test));

        app.setStrategy(new DequeStrategy());
        System.out.println("Using DequeStrategy: " +
                app.checkPalindrome(test));
    }
}