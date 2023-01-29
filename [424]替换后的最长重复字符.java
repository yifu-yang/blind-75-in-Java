
class Solution {
    public int characterReplacement(String s, int k) {

        return replace(s,k);
    }

    private int replace(String s, int k){
        if (s==null||s.length()==0) {
            return 0;
        }
        int ans = 0;
        int l = 0,r = 0;
        char c = s.charAt(l);
        while(l<s.length()-1){
            int tk = k;
            while((r<s.length())&&((s.charAt(r)==c)||(tk>0))){
                if (s.charAt(r)!=c) {
                    tk--;
                }
                r++;
            }
            ans = Math.max(ans, Math.min(r - l + tk, s.length()));
            l+=1;
            c = s.charAt(l);
            r = l;
        }
        return ans;
    }
}
