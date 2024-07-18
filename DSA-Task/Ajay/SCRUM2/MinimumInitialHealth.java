public class MinimumInitialHealth {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // dp[i][j] represents the minimum initial health needed to reach the bottom-right corner from cell (i, j)
        int[][] dp = new int[m][n];
        
        // Start from the bottom-right corner and initialize the value
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        // Initialize the last row
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        // Initialize the last column
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        // Fill the rest of the dp array
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }
        
        // The minimum initial health needed to reach the bottom-right corner from the top-left corner
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumInitialHealth mih = new MinimumInitialHealth();
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(mih.calculateMinimumHP(dungeon)); // Output: 7
    }
}

