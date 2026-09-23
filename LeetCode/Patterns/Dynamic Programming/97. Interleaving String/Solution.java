class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                boolean fromS1 = false;
                boolean fromS2 = false;

                // dp[j] still represents the previous row
                if (i > 0) {
                    fromS1 =
                        dp[j]
                        && s1.charAt(i - 1)
                           == s3.charAt(i + j - 1);
                }

                // dp[j - 1] represents the current row
                if (j > 0) {
                    fromS2 =
                        dp[j - 1]
                        && s2.charAt(j - 1)
                           == s3.charAt(i + j - 1);
                }

                dp[j] = fromS1 || fromS2;
            }
        }

        return dp[n];
    }
}