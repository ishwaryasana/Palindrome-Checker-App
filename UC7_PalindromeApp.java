import java.util.ArrayDeque;
import java.util.Deque;

public class UC7_PalindromeApp {
    public static void main(String[] args) {
        String input = "radar";
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : input.toCharArray()) {
            deque.add(c);
        }
        
        boolean isPalindrome = true;
        
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + isPalindrome);
    }
}