class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;

        //Array to store the next greater elements
        int nge[]=new int[n];
        Stack<Integer> stack=new Stack<>();

        //Iterate through the array twice to handle the circular nature
        for(int i=2*n-1;i>=0;i--){

            //While the stack is not empty and the top of the stack is less than or equal to the current element
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }

            //Only fill the result array for the first pass (i < n)
            if(i<n){
                if(stack.isEmpty()){
                    nge[i]=-1;
                }
                else{
                    nge[i]=stack.peek();
                }
            }
            //Push the current element onto the stack
            stack.push(nums[i%n]);
        }
        return nge;
    }
}
