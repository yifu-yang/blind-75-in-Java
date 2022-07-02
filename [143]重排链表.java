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
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while(tmp!=null){
            count++;
            tmp = tmp.next;
        }
        if(count ==1||count ==0){
            return ;    
        }
        ListNode[] arr = new ListNode[count];
        tmp = head;
        int i=0;
        while(tmp!=null){
            arr[i++] = tmp;
            tmp = tmp.next;
        }
        ListNode start = null;
        ListNode end = null;
        int l=0,r=count-1;
        for(;l<r;l++,r--){
            if(start==null){
                start = arr[l];
                arr[l].next = arr[r];
                end = arr[r];
            }else{
                end.next = arr[l];
                arr[l].next = arr[r];
                arr[r].next = null;
                end = arr[r];
            }
        }
        if(l==r){
            end.next = arr[l];
            arr[l].next = null;
        }
        head = start;
    }
}