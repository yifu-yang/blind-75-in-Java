class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
            if(o1[0] < o2[0]) { 
                return -1;
            }else if(o1[0] > o2[0]) {
                return 1;
            }else {
                if(o1[1] < o2[1]) { 
                    return -1;
                }else if(o1[1] > o2[1]) {
                    return 1;
                }else{
                    return 0;
                }    
            }
        }
        });
        Deque<int[]> stack = new ArrayDeque<>();
        for(int[] arr : intervals){
            if(stack.size()==0){
                stack.addLast(arr);
            }else{
                int[] top = stack.getLast();
                if(arr[0]<top[1]&&arr[1]<=top[1]){
                    stack.removeLast();
                    stack.addLast(arr);
                }else if(arr[0]<top[1]&&arr[1]>top[1]){
                    ;
                }else if(arr[0]>=top[1]){
                    stack.addLast(arr);
                }
            }
        }
        return intervals.length-stack.size();
    }
}