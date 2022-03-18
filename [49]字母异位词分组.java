class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();
        for(String str : strs){
            String chars = sign(str);
            List<String> strings;
            if(ans.containsKey(chars)){
                strings = ans.get(chars);
            }else{
                strings = new ArrayList<>();
            }
            strings.add(str);
            ans.put(chars,strings);
        }
        return new ArrayList<>(ans.values());
    }

    String sign(String str){
        int[] ans = new int[27];
        for(char c : str.toCharArray()){
            ans[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i=0;i<=26;i++){
            if(ans[i]!=0){
                for(int j =0;j<ans[i];j++){
                    key.append(String.valueOf('a' + i-1));
                }
            }
        }
        return key.toString();
    }
}
