class Solution {
    private static int[] xn = new int[]{-1,0,1,0};
    private static int[] yn = new int[]{0,-1,0,1};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board,String word,int index,int x,int y){
        if(word.charAt(index)!=board[x][y]){
            return false;
        }
        if(word.length()-1==index){
            return true;
        }
        char t = board[x][y];
        board[x][y] = '.';
        for(int i=0;i<xn.length;i++){
            if(x+xn[i]<0||x+xn[i]>=board.length||y+yn[i]<0||y+yn[i]>=board[0].length||board[x+xn[i]][y+yn[i]]=='.'){
                continue;
            }
            if(dfs(board,word,index+1,x+xn[i],y+yn[i])){
                return true;
            }
        }
        board[x][y]=t;
        return false;
    }
}