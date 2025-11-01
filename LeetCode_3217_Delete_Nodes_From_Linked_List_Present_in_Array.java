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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a HashSet to store values to be removed for O(1) lookup
        java.util.HashSet<Integer> map = new java.util.HashSet<>();
        for (int num : nums) {
            map.add(num);
        }

        // Dummy node simplifies edge cases, especially when head needs removal
        ListNode dummyNode = new ListNode(0, head);
        ListNode curr = dummyNode;

        // Traverse the list while checking the next node
        while (curr.next != null) {
            if (map.contains(curr.next.val)) {
                // Skip the node if its value is in the HashSet
                curr.next = curr.next.next;
            } else {
                // Move forward if current next node is not to be removed
                curr = curr.next;
            }
        }

        // Return the new head, which might be different if original head was removed
        return dummyNode.next;
    }
}
