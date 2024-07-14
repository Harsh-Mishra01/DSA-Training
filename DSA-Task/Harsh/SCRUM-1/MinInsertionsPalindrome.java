import java.util.Scanner;

public class MinInsertionsPalindrome {

    // Function to calculate the minimum insertions needed to make a string palindrome
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: A single character is always a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest palindromic subsequence
        int lpsLength = dp[0][n - 1];

        // The minimum insertions needed
        return n - lpsLength;
    }

    // Main function to test the code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        int result = minInsertions(input);
        System.out.println("Minimum insertions needed to make \"" + input + "\" a palindrome: " + result);
        
        scanner.close();
    }
}
