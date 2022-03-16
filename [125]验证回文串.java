//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 490 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)return true;
        int start = 0, end = s.length()-1;
        while(start<end){
            if(!valid(s.charAt(start))){
                start++;
                continue;
            }
            if(!valid(s.charAt(end))){
                end--;
                continue;
            }
            if(String.valueOf(s.charAt(end)).equalsIgnoreCase(String.valueOf(s.charAt(start)))){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    boolean valid(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
