//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1135 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Map<Integer,List<Integer>> reverse = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            heap.add(entry.getValue());
            List<Integer> list = reverse.getOrDefault(entry.getValue(),new ArrayList<>());
            list.add(entry.getKey());
            reverse.put(entry.getValue(),list);
        }
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        while (ans.size()<k){
            Integer head = heap.poll().intValue();
            if(head!=top){
                ans.addAll(reverse.get(head));
                top = head;
            }
        }
        int[] t = new int[k];
        for(int i=0;i<k;i++){
            t[i] = ans.get(i);
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
