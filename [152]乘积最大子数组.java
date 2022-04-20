class Solution {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dpmax[i] = nums[i];
                dpmin[i] = nums[i];
            }else{
                if(nums[i]>0){
                    dpmax[i] = Math.max(dpmax[i-1]*nums[i],nums[i]);
                    dpmin[i] = Math.min(dpmin[i-1]*nums[i],nums[i]);

                }else{
                    dpmax[i] = Math.max(dpmin[i-1]*nums[i],nums[i]);
                    dpmin[i] = Math.min(dpmax[i-1]*nums[i],nums[i]);
                }
            }
            ans = Math.max(ans,dpmax[i]);
        }
        return ans;
    }
}