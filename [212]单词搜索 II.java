class TrieNode {
    String word;
    Map<Character, TrieNode> map;

    TrieNode() {
        word = "";
        map = new HashMap<>();
    }
}

class Solution {
    int[] xn = new int[] { -1, 0, 1, 0 };
    int[] yn = new int[] { 0, 1, 0, -1 };

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addToTrie(root, word);
        }
        Set<String> ans = new HashSet<>();
        List<Character> c = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    void dfs(char[][] board, int x, int y, TrieNode node, Set<String> result) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.'
                || !node.map.containsKey(board[x][y])) {
            return;
        }
        TrieNode child = node.map.get(board[x][y]);
        if (!child.word.equals("")) {
            result.add(child.word);
        }
        char t = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < xn.length; i++) {
            dfs(board, x + xn[i], y + yn[i], child, result);
        }
        board[x][y] = t;
    }

    void addToTrie(TrieNode root, String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!root.map.containsKey(word.charAt(i))) {
                TrieNode n = new TrieNode();
                root.map.put(word.charAt(i), n);
            }
            if (i == word.length() - 1) {
                root.map.get(word.charAt(i)).word = word;
            }
            root = root.map.get(word.charAt(i));
        }
        root = tmp;
    }
}