class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        //max_left is the highest height at the left side
        //max_right is the highest height at the right side
        int max_left=0,max_right=0;
        //For calculating the amount of water trapped
        int water_trapped=0;
        //Iterating over all the heights from beginning to the end
        while(left<=right){
            //check if the left side is smaller than right side for trapping water
            if(height[left]<=height[right]){
                if(height[left]>=max_left){
                    max_left=height[left];
                }
                else{
                    water_trapped+=max_left-height[left];
                }
                left++;
            }
            //check if the right side is smaller than left side for trapping water
            else{
                if(height[right]>=max_right){
                    max_right=height[right];
                }
                else{
                    water_trapped+=max_right-height[right];
                }
                right--;
            }
        }
        //calculated the total amount of rain water trapped
        return water_trapped;
    }
}
