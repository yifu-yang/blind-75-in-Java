class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid;
        while(left<right){
            mid = (left+right)/2;
            if(nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }else{
                if(target>nums[mid]||target<nums[left]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left]==target){
            return left;
        }
        if(nums[right]==target){
            return right;
        }
        return -1;
    }
}
