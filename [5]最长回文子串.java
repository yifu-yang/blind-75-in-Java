//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4810 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1,start = 0,end=0;
        for(int i=0;i<s.length();i++){
            for (int j=0;j<=i;j++){
                if(i==j){
                    dp[i][j]=true;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i-1][j+1]||i-j==1;
                        if(dp[i][j]&&max<i-j+1){
                            max = i-j+1;
                            start = j;
                            end = i;
                        }
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
