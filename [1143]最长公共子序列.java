class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text2.length();i++){
            if(text1.charAt(0)==text2.charAt(i)){
                dp[0][i] = 1;
            }
            if(i>0){
                dp[0][i] = Math.max(dp[0][i-1],dp[0][i]);
            }
        }
        for(int i=0;i<text1.length();i++){
            if(text1.charAt(i)==text2.charAt(0)){
                dp[i][0] = 1;
            }
            if(i>0){
                dp[i][0] = Math.max(dp[i-1][0],dp[i][0]);
            }
        }
        for(int i=1;i<text1.length();i++){
            for(int j=1;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,Math.max(dp[i][j-1],dp[i-1][j]));
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}