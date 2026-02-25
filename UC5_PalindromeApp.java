import java.util.Scanner;
import java.util.Stack;

public class UC5_PalindromeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        
        boolean isPalindrome = input.equals(reversed);
        
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        
        sc.close();
    }
}