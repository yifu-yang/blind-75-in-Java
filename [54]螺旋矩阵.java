class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x1 = 0;
        int x2 = matrix.length-1;
        int y1 = 0;
        int y2 = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(x1<=x2&&y1<=y2){
            for(int i=y1;i<=y2;i++){
                ans.add(matrix[x1][i]);
            }
            x1++;
            for(int i=x1;i<=x2&&y1<=y2;i++){
                ans.add(matrix[i][y2]);
            }
            y2--;
            for(int i=y2;i>=y1&&x1<=x2;i--){
                ans.add(matrix[x2][i]);
            }
            x2--;
            for(int i =x2;i>=x1&&y1<=y2;i--){
                ans.add(matrix[i][y1]);
            }
            y1++;
        }
        return ans;
    }
}