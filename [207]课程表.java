class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        for(int[] p:prerequisites){
            if(p[0]==p[1])return false;
            ++in[p[0]];
        }
        List<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.add(i);
            }
        }
        for(int i=0;i<queue.size();i++){
            int n = queue.get(i);
            for(int[] p: prerequisites){
                if(p[1]==n){
                    in[p[0]]--;
                    if(in[p[0]]==0){
                        queue.add(p[0]);
                    }
                }
            }
        }
        return queue.size()==numCourses;
    }
}
