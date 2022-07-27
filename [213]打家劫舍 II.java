class Solution {
    public int rob(int[] nums) {
        int max = 0;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return max;
        }
        int[] dp1 = new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            dp1[i] = nums[i];
            for(int j=0;j<i-1;j++){
                dp1[i] = Math.max(dp1[j]+nums[i],dp1[i]);
            }
            max= Math.max(dp1[i],max);
        }
        dp1[0] = 0;
        for(int i=1;i<nums.length;i++){
            dp1[i] = nums[i];
            for(int j=0;j<i-1;j++){
                dp1[i] = Math.max(dp1[j]+nums[i],dp1[i]);
            }
            max= Math.max(dp1[i],max);
        }
        return max;
    }
}