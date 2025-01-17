class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        //Next Smaller Element
        int nse[]=new int[heights.length];
        //Previous Smaller Element
        int pse[]=new int[heights.length];
        Stack<Integer> stack=new Stack<>();

        // First pass to find NSE and PSE
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int index=stack.pop();
                // Set NSE for the popped index
                nse[index]=i;
                // Set PSE for the popped index
                pse[index]=stack.isEmpty()?-1:stack.peek();
                //Calculate Area
                max=Math.max(max,heights[index]*(nse[index]-pse[index]-1));
            }
            // Push current index onto the stack
            stack.push(i);
        }

        // Handle remaining elements in the stack
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()){
                int index=stack.pop();
                // Set NSE to n (end of array)
                nse[index]=heights.length;
                //Set PSE
                pse[index]=stack.isEmpty()?-1:stack.peek();
                //Calculate Area
                max=Math.max(max,heights[index]*(nse[index]-pse[index]-1));
            }
        }

        // Return the maximum area found
        return max;
    }
}
