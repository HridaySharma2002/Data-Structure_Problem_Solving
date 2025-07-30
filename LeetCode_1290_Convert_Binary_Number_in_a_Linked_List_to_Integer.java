/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;          // Value of the node
 *     ListNode next;    // Reference to the next node in the list
 *     ListNode() {}     // Default constructor
 *     ListNode(int val) { this.val = val; }  // Constructor with value initialization
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node initialization
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        // Initialize result with the value of the head node
        int result = head.val;
        
        // Traverse the linked list until the last node
        while (head.next != null) {
            // Left shift result by 1 bit to make space for the next bit,
            // then add the next node's value using bitwise OR
            result = (result << 1) | head.next.val;
            
            // Move to the next node
            head = head.next;
        }
        
        // Return the computed decimal value of the binary number represented by the linked list
        return result;
    }
}
