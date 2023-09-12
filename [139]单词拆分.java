class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] ans = new boolean[s.length()];
        for(int i=0;i<ans.length;i++){
            for(String key:set){
                if(s.substring(i,s.length()).startsWith(key)){
                    ans[i+key.length()-1]=ans[i+key.length()-1]||(i==0?true:ans[i-1]);
                }
            }
        }
        return ans[ans.length-1];
    }
}
