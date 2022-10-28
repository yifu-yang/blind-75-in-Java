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