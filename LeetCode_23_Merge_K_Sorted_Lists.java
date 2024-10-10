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
        PriorityQueue<ListNode>minheap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head:lists){
            if(head!=null){
                minheap.add(head);
            }
        }

        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while(!minheap.isEmpty()){
            ListNode node=minheap.poll();
            temp.next=node;
            temp=temp.next;
            if(node.next!=null){
                minheap.add(node.next);
            }
        }
        return dummyNode.next;
    }
}
