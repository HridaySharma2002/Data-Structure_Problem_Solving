/**
 * Definition for singly-linked list.
 * Each node contains an integer value and a reference to the next node.
 * public class ListNode {
 *     int val; // Value stored in the node
 *     ListNode next; // Reference to the next node in the list
 *     ListNode() {} // Default constructor
 *     ListNode(int val) { this.val = val; } // Constructor with value
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If both lists are not null, compare their current node values
        if(list1 != null && list2 != null){
            // If list1's value is less, use list1's node and merge the rest
            if(list1.val < list2.val){
                // Recursively merge the next node of list1 with list2
                list1.next = mergeTwoLists(list1.next, list2);
                return list1; // Return list1 as the current node
            } else {
                // Otherwise, use list2's node and merge list1 with the next node of list2
                list2.next = mergeTwoLists(list1, list2.next);
                return list2; // Return list2 as the current node
            }
        }
        // If list1 is null, return list2 (could be null or a remaining list)
        if(list1 == null){
            return list2;
        }
        // If list2 is null, return list1 (remaining nodes)
        return list1;
    }
}
