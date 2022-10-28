//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] sa = new int[52];
    int[] ta = new int[52];

    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        sa = getArray(s.substring(left, right+1));
        ta = getArray(t);
        int count = Integer.MAX_VALUE;
        String ans = "";
        while (left <= right && right < s.length()) {
            if (match(sa, ta)) {
                if ((right - left+1 )< count) {
                    ans = s.substring(left, right + 1);
                    count = right - left+1;
                }
                if (left < s.length()-1) {
                    sa = update(sa, s.charAt(left), -1);
                }
                left++;
            } else  {
                right++;
                if (right < s.length()){
                    sa = update(sa, s.charAt(right), 1);
                }
            }
        }
        return ans;
    }

    int[] update(int[] array, char c, int value) {
        if (c <= 'Z') {
            array[c - 'A'] += value;
        } else {
            array[c - 'a' + 26] += value;
        }
        return array;
    }

    int[] getArray(String s) {
        int[] array = new int[52];
        for (char c : s.toCharArray()) {
            if (c <= 'Z') {
                array[c - 'A']++;
            } else {
                array[c - 'a' + 26]++;
            }
        }
        return array;
    }

    boolean match(int[] s, int[] t) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] < t[i]) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
