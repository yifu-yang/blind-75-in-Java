class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j){
                        ans++;
                        dp[i][j]=true;
                    }else{
                        if((i-1>=0&&j+1<s.length()&&dp[i-1][j+1])||Math.abs(i-j)==1){
                            dp[i][j] = true;
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}