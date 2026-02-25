import java.util.Scanner;

public class UC11_PalindromeApp {

    private String input;

    public UC11_PalindromeApp(String input) {
        this.input = input;
    }

    public boolean isPalindrome() {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = input.nextLine();

        UC11_PalindromeApp checker = new UC11_PalindromeApp(word);

        System.out.println("Is Palindrome? " + checker.isPalindrome());

        input.close();
    }
}