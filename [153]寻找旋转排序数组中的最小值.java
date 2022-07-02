class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        while(start<end-1){
            if(nums[mid]<nums[start]){
                end = mid;
                mid = (start+end)/2;
            }else if(nums[end]<nums[mid]){
                start =mid;
                mid = (start+end)/2;
            }else{
                end = mid;
                mid = (start+end)/2;
            }
        }
        return Math.min(nums[start],nums[end]);
    }
}