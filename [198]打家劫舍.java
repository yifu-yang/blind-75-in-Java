class Solution {
    public int rob(int[] nums) {
        int[] dp =new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(i<2){
                dp[i] = nums[i];
                ans = Math.max(dp[i],ans);
                continue;
            }
            for(int j=0;j<i-1;j++){
                dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                ans = Math.max(dp[i],ans);
            }
        }
        return ans;
    }
}