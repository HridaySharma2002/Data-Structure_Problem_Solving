class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[]=new int[nums1.length];
        Stack<Integer> stack=new Stack<>();

        Map<Integer,Integer> nge_map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            // Pop elements from the stack that are less than or equal to the current element
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }

            // If the stack is empty, there is no greater element 
            // Otherwise, the top of the stack is the next greater element
            nge_map.put(nums2[i],stack.isEmpty()? -1 :stack.peek());
            stack.push(nums2[i]);
        }

        //Populate the result array using ngeMap
        for(int i=0;i<nums1.length;i++){
            result[i]=nge_map.get(nums1[i]);
        }

        return result;
    }
}
