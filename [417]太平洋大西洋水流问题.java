class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] marked = new boolean[heights.length][heights[0].length];
        boolean[][] marked2 = new boolean[heights.length][heights[0].length];
        for(int i=0;i< heights[0].length;i++){
            dfs(heights,pacific,0,i,marked,true);
            dfs(heights,atlantic, heights.length-1, i,marked2,false);
        }
        marked = new boolean[heights.length][heights[0].length];
        marked2 = new boolean[heights.length][heights[0].length];
        for(int i=0;i< heights.length;i++){
            dfs(heights,pacific,i,0,marked,true);
            dfs(heights,atlantic, i, heights[0].length-1, marked2,false);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for (int j=0;j<heights[0].length;j++){
                if(pacific[i][j]&&(atlantic[i][j])){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    private static final int[][] direction = new int[][]{
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    void dfs(int[][] heights,boolean[][] pacific,int i,int j,boolean[][] marked,boolean flag){
        if (marked[i][j])return;
        marked[i][j] =true;
        if(flag){
            if(i==0||j==0){
                pacific[i][j] = true;
            }
        }else {
            if((i==heights.length-1)||(j==heights[0].length-1)){
                pacific[i][j] = true;
            }
        }

        for(int[] index :direction){
            if(i+index[0]>=0&&i+index[0]< heights.length
                    &&j+index[1]>=0&&j+index[1]<heights[0].length
            ){
                if(pacific[i][j]&&heights[i][j]<=heights[i+index[0]][j+index[1]]){
                    pacific[i+index[0]][j+index[1]] = true;
                    dfs(heights,pacific,i+index[0],j+index[1],marked,flag);
                }

            }
        }
    }
}
