public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxLength = 1;

        // Initialize the dp array, each element is 1 by default
        // because the minimum length of LIS ending at any element is 1 (the element itself)
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        // Compute the LIS for each element
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("The length of the longest increasing subsequence is: " + lengthOfLIS(nums));
    }
}
