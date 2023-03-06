class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0)return ans;
        Arrays.sort(candidates);
        if(candidates[0]>target)return ans;
        for(int i = 0;i<candidates.length;i++){
            List<Integer> sub = new ArrayList<>();
            sub.add(candidates[i]);
            backtracking(sub,candidates[i],i,candidates,target);
        }
        return ans;
    }

    void backtracking(List<Integer> a ,int sum,int i,int[] candidates,int target){
        if(sum==target) {
            List<Integer> n = new ArrayList<>(a);
            ans.add(n);
            return;
        }
        if(sum>target)return;
        for(int start = i; start<candidates.length; start++){
            a.add(candidates[start]);
            backtracking(a,sum+candidates[start],start,candidates,target);
            a.remove(a.size()-1);
        }
    }
}