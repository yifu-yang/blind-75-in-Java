class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,int[]> ans = new HashMap<>();
        if(nums.length==0)return 0;
        for(int num : nums){
            if (ans.containsKey(num))continue;
            if(ans.containsKey(num-1)){
                int[] index = ans.get(num-1);
                index[1]=num;
                ans.put(num,index);
            }
            if(ans.containsKey(num+1)){
                int[] index = ans.get(num+1);
                index[0]=ans.containsKey(num)?ans.get(num)[0]:num;
                ans.put(num,index);
                ans.put(index[0],index);
                ans.put(index[1],index);
            }
            if(!ans.containsKey(num-1)&&!ans.containsKey(num+1)){
                int[] index = new int[2];
                index[0]= num;
                index[1] = num;
                ans.put(num,index);
            }
        }
        int max = 1;
        for (int num : nums){
            int[] count = ans.get(num);
            max = Math.max(count[1]-count[0]+1,max);
        }
        return max;
    }
}
