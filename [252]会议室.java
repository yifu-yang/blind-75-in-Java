
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
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(d1, d2) -> {
	        if(d1.start!=d2.start){
                return d1.start - d2.start;
            }
            return d1.end-d2.end;
        });
        Deque<Integer> stack = new ArrayDeque<>();
        for(Interval i : intervals){
            if(stack.size()==0){
                stack.addLast(i.end);
            }else{
                if(i.start<stack.getLast()){
                    return false;
                }else{
                    stack.addLast(i.end);
                }
            }
        }
        return true;
    }
}