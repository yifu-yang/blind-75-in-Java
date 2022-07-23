/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode ans= lists[0];
        for(int i=1;i<lists.length;i++){
            ans= merge(ans,lists[i]);
        }
        return ans;
    }

    ListNode merge(ListNode n1,ListNode n2){
        ListNode ans = new ListNode();
        ListNode head = ans;
        while(n1!=null&&n2!=null){
            if(n1.val<n2.val){
                ListNode tmp = n1.next;
                n1.next = null;
                head.next = n1;
                n1 = tmp;
            }else{
                ListNode tmp = n2.next;
                n2.next = null;
                head.next = n2;
                n2 = tmp;
            }
            head = head.next;
        }
        if(n1==null){
            head.next = n2;
        }
        if(n2==null){
            head.next = n1;
        }
        return ans.next;
    }
}