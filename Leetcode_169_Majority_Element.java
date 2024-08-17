class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=0;
        int element=0;
        //Moore's voting algorithm
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(element==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

        //Checking if the Stored Element got majority or not
        int count_1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element){
                count_1++;
            }
            if(count_1>(n/2)){
                return element;
            }
        }
        return -1;
    }
}
