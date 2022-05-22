class Trie {
    private Trie[] chars;
    private boolean stop;
    public Trie() {
        chars = new Trie[26];
        stop = false;
    }
    
    public void insert(String word) {
        if(word.length()!=0){
            Trie newNode;
            if(chars[word.charAt(0)-'a']==null){
                newNode = new Trie();
                chars[word.charAt(0)-'a'] = newNode;    
            }else{
                newNode = chars[word.charAt(0)-'a'];
            }
            newNode.insert(word.substring(1,word.length()));
        }else{
            stop = true;
        }
    }
    
    public boolean search(String word) {
        if(word.length()==0&&stop ){
            return true;
        }else{
            if(word.length()==0||chars[word.charAt(0)-'a']==null)return false;
            return chars[word.charAt(0)-'a'].search(word.substring(1,word.length()));
        }
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length()==0 ){
            return true;
        }else{
            if(chars[prefix.charAt(0)-'a']==null)return false;
            return chars[prefix.charAt(0)-'a'].startsWith(prefix.substring(1,prefix.length()));
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */