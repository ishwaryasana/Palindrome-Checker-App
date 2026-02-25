public class UC10_PalindromeApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        
        String normalized = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        boolean isPalindrome = true;
        
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}