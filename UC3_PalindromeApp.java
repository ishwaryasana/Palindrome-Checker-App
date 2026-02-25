public class UC3_PalindromeApp {
    public static void main(String[] args) {
        String input = "madam";
        String reversed = "";
        
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        
        if (input.equals(reversed)) {
            System.out.println("Input text: " + input);
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Input text: " + input);
            System.out.println("Is it a Palindrome? : false");
        }
    }
}