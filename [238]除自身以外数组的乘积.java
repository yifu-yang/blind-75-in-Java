class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] head = new int[nums.length],tail = new int[nums.length];
        for(int i=0;i<head.length;i++){
            if(i==0){
                head[i]=nums[i];
                continue;
            }
            head[i]= head[i-1]*nums[i];
        }
        for(int i=tail.length-1;i>=0;i--){
            if(i==tail.length-1){
                tail[i]=nums[i];
                continue;
            }
            tail[i]= tail[i+1]*nums[i];
        }
        int[] ans =new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans[i]= 1*tail[i+1];
                continue;
            }
            if(i==ans.length-1){
                ans[i] = 1*head[i-1];
                continue;
            }
            ans[i] = head[i-1]*tail[i+1];
        }
        return ans;
    }
}