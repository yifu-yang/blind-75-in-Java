public class TrieNode{
    public boolean isWord;
    public Map<String,TrieNode> map;
    public TrieNode(){
        isWord = false;
        map = new HashMap<>();
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(String.valueOf(word.charAt(i)))){
               TrieNode n = new TrieNode();
               node.map.put(String.valueOf(word.charAt(i)),n); 
            }
            node = node.map.get(String.valueOf(word.charAt(i)));
            if(i==word.length()-1){
                node.isWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        return dfs(root,word,0);
    }

    boolean dfs(TrieNode node ,String word, int index){
        if(index==word.length()){
            return node.isWord;
        }
        if(node.map.containsKey(String.valueOf(word.charAt(index)))){
            boolean strick = dfs(node.map.get(String.valueOf(word.charAt(index))),word,index+1);
            if(strick)return true;
        }
        if(word.charAt(index)=='.'){
            for(String key:node.map.keySet()){
                boolean dot = dfs(node.map.get(key),word,index+1);
                if(dot)return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */