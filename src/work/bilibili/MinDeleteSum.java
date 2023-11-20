package work.bilibili;

/**
 * @author heyao
 * @date 2023-08-29 19:29
 */
public class MinDeleteSum {
    public int minDeleteSum (String s1, String s2) {
        int m = s1.length(),n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i < m;i++){
            dp[i][0] = dp[i-1][0]+s1.charAt(i-1);
        }
        for(int i = 1;i < n;i++){
            dp[0][i] = dp[0][i-1]+s2.charAt(i-1);
        }
        for(int i = 1;i <= m;i++){
            char a = s1.charAt(i-1);
            for(int j = 1;j <= n;j++){
                char b = s2.charAt(j-1);
                if(a == b){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+a,dp[i][j-1]+b);
                }
            }
        }
        return dp[m][n];
    }

    int solution(String virusA,String virusB,int x,int y,int z){
        int n = virusA.length();
        int m = virusB.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (virusA.charAt(i - 1) == virusB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
