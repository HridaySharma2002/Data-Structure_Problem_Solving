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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode current = head; // Pointer to traverse the linked list
        ListNode prev = null; // Pointer to keep track of the end of the previous group
        ListNode temp = null; // Temporary pointer for node manipulation
        int groupsize = 1; // Initialize the size of the current group

        // Traverse the linked list until all nodes are processed
        while (current != null) {
            int len = 1; // Initialize the length of the current group

            // Determine the length of the current group
            while (len < groupsize) {
                if (current.next == null) { // Check if we reach the end of the list
                    break; // Exit if there are no more nodes
                }
                current = current.next; // Move to the next node
                len++; // Increment the length of the group
            }

            // If the length of the group is even, reverse the nodes in this group
            if (len % 2 == 0) {
                current = prev.next; // Start reversing from the first node of the current group
                while (len > 1) { // Reverse the nodes in the group
                    temp = current.next; // Store the next node
                    current.next = temp.next; // Link current node to the node after temp
                    temp.next = prev.next; // Link temp to the start of the reversed part
                    prev.next = temp; // Update the previous group's end to point to temp
                    len--; // Decrease the length counter
                }
            }

            // Update pointers for the next iteration
            prev = current; // Move prev to the end of the current group
            current = current.next; // Move curr to the next node
            groupsize++; // Increment the group size for the next iteration
        }

        return head; // Return the modified linked list
    }
}
