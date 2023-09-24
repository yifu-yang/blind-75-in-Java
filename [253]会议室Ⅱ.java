/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0)return 0;
        // Write your code here
        Collections.sort(intervals,(d1,d2)->{
            if(d1.start!=d2.start){
                return d1.start-d2.start;
            }
            return d1.end-d2.end;
        });
        Deque<Integer> stack = new ArrayDeque<>();
        List<Interval> sub = new  ArrayList<>();
        for(Interval i : intervals ){
            if(stack.size()==0){
                stack.addLast(i.end);
            }else{
                if(stack.getLast()>i.start){
                    sub.add(i);
                }else{
                    stack.addLast(i.end);
                }
            }
        }
        return 1+minMeetingRooms(sub);
    }
}