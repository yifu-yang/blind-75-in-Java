class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean flag = false;
        for(int[] range:intervals){
            if(newInterval[0]<range[0]&&!flag){
                flag=true;
                ans.add(newInterval);
                ans.add(range);
            }else{
                ans.add(range);
            }
        }
        if(!flag){
            ans.add(newInterval);
        }
        return merge(ans);
    }

    int[][] merge(List<int[]> list){
        Deque<int[]> ans= new ArrayDeque<>();
        for(int[] arr : list){
            if(ans.size()==0){
                ans.addLast(arr);
            }else{
                int[] pre = ans.getLast();
                if(arr[0]<=pre[0]){
                    int[] tmp = new int[2];
                    tmp[0] = arr[0];
                    tmp[1] = Math.max(arr[1],pre[1]);
                    ans.removeLast();
                    ans.addLast(tmp); 
                }else if(arr[0]<=pre[1]){
                    int[] tmp = new int[2];
                    tmp[0] = pre[0];
                    tmp[1] = Math.max(arr[1],pre[1]);
                    ans.removeLast();
                    ans.addLast(tmp);
                }else if(arr[0]>pre[1]){
                    ans.addLast(arr);
                }
            }
        }
        return ans.toArray(new int[0][0]);
    }
}