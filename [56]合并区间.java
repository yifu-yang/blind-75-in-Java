//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1532 👎 0


import java.util.ArrayDeque;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> ans = new ArrayDeque<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return a[0]-b[0];
            }
        });
        for(int[] arr: intervals){
            if(ans.size()==0){
                ans.addLast(arr);
            }else{
                int[] last = ans.getLast();
                if(arr[0]<=last[0]){
                    int[] tmp = new int[2];
                    tmp[0] = arr[0];
                    tmp[1] = Math.max(arr[1],last[1]);
                    ans.removeLast();
                    ans.addLast(tmp);
                }else if(arr[0]<=last[1]){
                    int[] tmp = new int[2];
                    tmp[0] = last[0];
                    tmp[1] = Math.max(arr[1],last[1]);
                    ans.removeLast();
                    ans.addLast(tmp);
                }else if(arr[0]>last[1]){
                    ans.addLast(arr);
                }
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
