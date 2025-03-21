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
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty or has only one node, return it as is
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tra = head;          // Pointer to track the last unique node
        ListNode temp = head.next;    // Pointer to traverse the list starting from the second node

        while (temp != null) {
            if (temp.val != tra.val) { // Check if the current node's value is different from the last unique value
                tra.next = temp;       // Link the last unique node to the current node
                tra = temp;            // Move the 'tra' pointer to the current node
            }
            // Move 'temp' to the next node regardless of whether it was a duplicate or not
            temp = temp.next;         
        }
        // Ensure the last unique node points to null
        tra.next = null;               
        return head;                   // Return the modified list
    }
}
